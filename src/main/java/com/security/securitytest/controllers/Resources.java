package com.security.securitytest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Resources {

    @GetMapping
    public ResponseEntity<?> test(){
        Authentication autentication = SecurityContextHolder.getContext().getAuthentication();
        String autoridade = String.valueOf(autentication.getAuthorities());
        return ResponseEntity.ok("Teste: "+autoridade);
    }

    @GetMapping("/jwt")
    public ResponseEntity<?> testJwt( @RequestHeader String Authorization){
        return ResponseEntity.ok("Deve funcionar somente com JWT: "+Authorization);
    }

}
