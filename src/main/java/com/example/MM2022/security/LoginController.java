package com.example.MM2022.security;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class LoginController {
    @PostMapping("/public/login")
    public void  sampleLogin(@RequestBody LoginRequest loginRequest){

    }
}


