package com.example.devideasbackendauth.service;


import com.devideas.devideasbackendcommon.dto.response.GenericResponses;

public interface LoginService {

    GenericResponses<Object> auth(String email, String password);
}
