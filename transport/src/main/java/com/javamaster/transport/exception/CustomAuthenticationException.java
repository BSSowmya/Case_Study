package com.javamaster.transport.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String message,String classname) {
        super(message);
    }
}
