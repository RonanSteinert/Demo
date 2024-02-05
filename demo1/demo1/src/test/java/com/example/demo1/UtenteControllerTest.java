package com.example.demo1;

import com.example.demo1.Controller.UtenteController;
import com.example.demo1.Model.Utente;
import com.example.demo1.Service.impl.UtenteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.demo1.Model.Enum.Ruolo.ADMIN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Demo1Application.class)
@AutoConfigureMockMvc
class UtenteControllerTest {

    private UtenteController utenteController;

    @Mock
    private UtenteServiceImpl utenteService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    private Utente utente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        utenteController = new UtenteController(utenteService);

        utente = new Utente();
        utente.setIdUtente(1L);
        utente.setNome("Pino");
        utente.setCognome("Brambilla");
        utente.setEmail("@test.it");
    }

    @Test
    void saveUtente() throws Exception {

        when(utenteService.saveUtente(utente)).thenReturn(utente);


        ResponseEntity<Utente> responseEntity = utenteController.saveUtente(utente);

        assertEquals(responseEntity.getStatusCodeValue(), 201);

        Utente savedUtente = responseEntity.getBody();
        assertNotNull(utente);
        assertEquals(utente.getNome(), savedUtente.getNome());
    }

    @Test
    void saveUtente_Failure() throws Exception {

        when(utenteService.saveUtente(utente)).thenThrow(new RuntimeException("Errore durante il salvataggio dell'utente"));


        ResponseEntity<Utente> responseEntity = utenteController.saveUtente(utente);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

        assertNull(responseEntity.getBody());
    }

    @Test
    void getUtenteById_ExistingUser() {

        Long userId = 1L;

        Utente utenteEsistente = new Utente();
        utenteEsistente.setIdUtente(userId);
        when(utenteService.getUtenteById(userId)).thenReturn(Optional.of(utenteEsistente));

        ResponseEntity<Utente> responseEntity = utenteController.getUtenteById(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(utenteEsistente, responseEntity.getBody());
    }

    @Test
    void getUtenteById_NonExistingUser() {
        Long userId = 2L;

        when(utenteService.getUtenteById(userId)).thenReturn(Optional.empty());

        ResponseEntity<Utente> responseEntity = utenteController.getUtenteById(userId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

        assertNull(responseEntity.getBody());
    }

    @Test
    void getAllUtenti_Success() {
        // Simula una lista di utenti
        List<Utente> utenti = Arrays.asList(
                new Utente(1L, "Mario", "Rossi", "mario@rossi.com","pass", ADMIN),
                new Utente(2L, "gino", "brambilla", "mario@rossi.com","pass", ADMIN)
        );

        when(utenteService.getAllUtenti()).thenReturn(utenti);

        ResponseEntity<List<Utente>> responseEntity = utenteController.getAllUtenti();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(utenti, responseEntity.getBody());
    }

    @Test
    void getAllUtenti_Failure() {

        when(utenteService.getAllUtenti()).thenThrow(new RuntimeException("Errore durante il recupero degli utenti"));

        ResponseEntity<List<Utente>> responseEntity = utenteController.getAllUtenti();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

        assertNull(responseEntity.getBody());
    }

    @Test
    void deleteUtenteById_Success() throws Exception {
        Long utenteId = 1L;

        // Esegui la richiesta HTTP simulata per eliminare l'utente
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{id}", utenteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        // Verifica che il servizio sia stato chiamato con l'ID corretto
        verify(utenteService, times(1)).deleteUtenteById(eq(utenteId));
    }

    @Test
    void deleteUtenteById_InternalServerError() throws Exception {
        Long utenteId = 1L;

        // Simula il comportamento in cui il servizio lancia un'eccezione quando si tenta di eliminare l'utente
        doThrow(new RuntimeException("Errore durante eliminazione dell'utente")).when(utenteService).deleteUtenteById(utenteId);

        // Esegui la richiesta HTTP simulata per eliminare l'utente
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{id}", utenteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Errore durante eliminazione dell'utente"));

        // Verifica che il servizio sia stato chiamato con l'ID corretto
        verify(utenteService, times(1)).deleteUtenteById(eq(utenteId));
    }
}
