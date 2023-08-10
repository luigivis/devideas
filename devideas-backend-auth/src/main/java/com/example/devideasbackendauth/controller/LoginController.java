package com.example.devideasbackendauth.controller;

import com.example.devideasbackendauth.advice.LoginAdvice;
import com.example.devideasbackendauth.dto.request.LoginDTO;
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

  @Autowired private LoginAdvice loginAdvice;

  @PostMapping
  public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
    return loginAdvice.loginVerified(loginDTO);
  }
}
