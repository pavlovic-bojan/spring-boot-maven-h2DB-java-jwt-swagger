package com.pavlovicbojan.demo.service;

import com.pavlovicbojan.demo.payload.LoginDto;
import com.pavlovicbojan.demo.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}