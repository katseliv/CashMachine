package com.dataart.cashmachine.rest.api;

import com.dataart.cashmachine.service.logic.AuthenticationService;
import com.dataart.cashmachine.service.model.create_dto.CardCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/log")
//public class AuthenticationController {
//
//    private final AuthenticationService authenticationService;
//
//    @Autowired
//    public AuthenticationController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @PostMapping()
//    public String authorize(@RequestBody CardCreateDto dto) {
//        return authenticationService.generateToken(dto);
//    }
//
//}
