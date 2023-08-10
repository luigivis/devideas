package com.example.devideasbackendauth.dto.request;

import lombok.Data;

@Data
public class LoginDTO {
    private String email, password;
}
