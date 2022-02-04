package com.dataart.cashmachine.rest.api;

import com.dataart.cashmachine.service.logic.AuthenticationService;
import com.dataart.cashmachine.service.logic.OperationsHistoryService;
import com.dataart.cashmachine.service.model.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashmachine/card")
public class OperationsHistoryController {

    private final AuthenticationService authService;
    private final OperationsHistoryService service;

    @Autowired
    public OperationsHistoryController(AuthenticationService authService,
                                       OperationsHistoryService service) {
        this.authService = authService;
        this.service = service;
    }

    @PutMapping("/{token}/{cardId}/balance/history")
    public ResponseEntity<CardDto> addRecordAboutCheckingBalance(@PathVariable String token, @PathVariable long cardId) {
        if (authService.verifyToken(cardId, token)) {
            service.addRecordAboutCheckingBalance(cardId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{token}/{cardId}/withdrawal/history")
    public ResponseEntity<CardDto> addRecordAboutWithdrawal(@PathVariable String token, @PathVariable long cardId) {
        if (authService.verifyToken(cardId, token)) {
            service.addRecordAboutWithdrawal(cardId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
