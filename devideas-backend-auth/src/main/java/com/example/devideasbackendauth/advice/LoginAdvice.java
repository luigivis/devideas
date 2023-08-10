package com.example.devideasbackendauth.advice;

import com.devideas.devideasbackendcommon.dto.response.GenericResponses;
import com.devideas.devideasbackendcommon.dto.response.StatusDTO;
import com.example.devideasbackendauth.dto.request.LoginDTO;
import com.example.devideasbackendauth.service.imp.LoginServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginAdvice {
  @Autowired private LoginServiceImp service;

  public ResponseEntity<GenericResponses<Object>> loginVerified(LoginDTO loginDTO) {
    var genericResponse = new GenericResponses<>();
    if (null == loginDTO || loginDTO.getEmail().isEmpty() || loginDTO.getPassword().isEmpty()) {
      genericResponse.setStatus(new StatusDTO(HttpStatus.BAD_REQUEST));
      genericResponse.setBody(loginDTO);
      return genericResponse.getResponseHttp(genericResponse);
    }

    genericResponse = service.auth(loginDTO.getEmail(), loginDTO.getPassword());
    genericResponse.setBody(loginDTO);
    return genericResponse.getResponseHttp(genericResponse);
  }
}
