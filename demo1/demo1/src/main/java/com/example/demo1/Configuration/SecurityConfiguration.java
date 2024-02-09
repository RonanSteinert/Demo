package com.example.demo1.Configuration;

import com.example.demo1.Service.impl.UserDetailsServiceImpl;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.Security;
@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
        @Autowired
        UserDetailsService userDetailsService;

        @Autowired
        private AuthEntryPointJwt unauthorizedHandler;

        @Bean
        public AuthTokenFilter authenticationJwtTokenFilter() {
            return new AuthTokenFilter();
        }
        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(userDetailsService);
            authProvider.setPasswordEncoder(passwordEncoder());
            return authProvider;
        }
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
            return authConfig.getAuthenticationManager();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())
                    .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(auth ->
                            auth.requestMatchers(HttpMethod.GET, "/api/ricette/**").permitAll()
                                    .requestMatchers(HttpMethod.GET, "/api/categorie/**").permitAll()
                                    .requestMatchers(HttpMethod.GET, "/api/test/all").permitAll()
                                    //.requestMatchers("/api/utente/admin/**").hasAuthority("ADMIN")
                                    .requestMatchers("/api/auth/**").permitAll()
                                    .anyRequest().authenticated()
                    );
            http.authenticationProvider(authenticationProvider());

            http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
}

