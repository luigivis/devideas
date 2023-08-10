package com.example.devideasbackendauth.controller;

import com.example.devideasbackendauth.service.imp.LoginServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = loginServiceImp.auth(email, password);

        if (authenticated) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

}
