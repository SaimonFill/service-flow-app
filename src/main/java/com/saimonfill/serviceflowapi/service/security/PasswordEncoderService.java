package com.saimonfill.serviceflowapi.service.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService extends BCryptPasswordEncoder {
}
