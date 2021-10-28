package com.geekbrains.ru.springproduct.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}

