package com.example.devideasbackendauth.service.imp;

import com.example.devideasbackendauth.entity.LoginEntity;
import com.example.devideasbackendauth.repository.LoginRepository;
import com.example.devideasbackendauth.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean auth(String email, String password) {

        LoginEntity user = loginRepository.findByEmail(email);
        log.info("{}", user);

        if (user != null && user.getPassword().equals(password)) {
            log.info("{}", user);
            return true;
        }
        log.info("{}", user);
        return false;

    }

}