package com.example.demo1.Controller;

import com.example.demo1.Model.AuthenticationResponse;
import com.example.demo1.Model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/demo-controller")
public class DemoController {
    @GetMapping()
    public ResponseEntity<String> hello(){

        return ResponseEntity.ok("Ciao!");
    }
}
