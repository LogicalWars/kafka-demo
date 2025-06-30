package ru.netology.creditapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.creditapplication.dto.request.CreditRequest;
import ru.netology.creditapplication.service.CreditService;

@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping
    public ResponseEntity<Long> createCredit(@RequestBody CreditRequest request) {
        return ResponseEntity.ok(creditService.createCredit(request));
    }
}
