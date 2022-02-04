package com.dataart.cashmachine.rest.api;

import com.dataart.cashmachine.service.logic.AuthenticationService;
import com.dataart.cashmachine.service.logic.CardService;
import com.dataart.cashmachine.service.model.CardDto;
import com.dataart.cashmachine.service.model.OperationsHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashmachine/card")
public class CardController {

    private final AuthenticationService authService;
    private final CardService service;

    @Autowired
    public CardController(AuthenticationService authService,
                          CardService service) {
        this.authService = authService;
        this.service = service;
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardDto> getUnblockedCard(@PathVariable long cardId) {
        CardDto cardDto = service.getCardById(cardId);
        if (cardDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cardDto, HttpStatus.OK);
    }

    @PutMapping("/{token}/{cardId}/block")
    public ResponseEntity<CardDto> blockCard(@PathVariable String token, @PathVariable long cardId) {
        if (authService.verifyToken(cardId, token)) {
            service.blockCardById(cardId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{token}/{cardId}/balance")
    public ResponseEntity<Integer> getCardBalance(@PathVariable String token, @PathVariable long cardId) {
        if (authService.verifyToken(cardId, token)) {
            return new ResponseEntity<>(service.getCardBalanceById(cardId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{token}/{cardId}/withdrawal")
    public ResponseEntity<CardDto> withdrawCash(@PathVariable String token, @PathVariable long cardId, @RequestBody int sum) {
        if (authService.verifyToken(cardId, token)) {
            if (!service.withdrawCashFromCardById(cardId, sum)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{token}/{cardId}/operations")
    public ResponseEntity<List<OperationsHistoryDto>> getAllCompletedOperations(@PathVariable String token, @PathVariable long cardId) {
        if (authService.verifyToken(cardId, token)) {
            return new ResponseEntity<>(service.getAllCompletedOperationsById(cardId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}
