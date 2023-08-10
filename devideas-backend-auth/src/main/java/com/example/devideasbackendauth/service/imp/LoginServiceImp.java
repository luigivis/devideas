package com.example.devideasbackendauth.service.imp;

import com.devideas.devideasbackendcommon.dto.response.GenericResponses;
import com.devideas.devideasbackendcommon.dto.response.StatusDTO;
import com.example.devideasbackendauth.repository.LoginRepository;
import com.example.devideasbackendauth.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class LoginServiceImp implements LoginService {

  @Autowired private LoginRepository loginRepository;

  @Override
  public GenericResponses<Object> auth(String email, String password) {

    var genericResponse = new GenericResponses<>();
    var user = loginRepository.findByEmail(email);
    log.info("{}", user);

    if (user != null && user.getPassword().equals(password)) {
      log.info("{}", user);
      genericResponse.setStatus(new StatusDTO(HttpStatus.OK));
      return genericResponse;
    }
    log.info("{}", user);
    genericResponse.setStatus(new StatusDTO(HttpStatus.UNAUTHORIZED));
    return genericResponse;
  }
}
