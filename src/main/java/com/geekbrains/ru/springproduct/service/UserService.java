package com.geekbrains.ru.springproduct.service;

import com.geekbrains.ru.springproduct.domain.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserEntity findByUsername(String username);
}
