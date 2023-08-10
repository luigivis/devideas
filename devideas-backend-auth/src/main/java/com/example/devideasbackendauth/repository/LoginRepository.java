package com.example.devideasbackendauth.repository;

import com.example.devideasbackendauth.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    LoginEntity findByEmail(String email);
}
