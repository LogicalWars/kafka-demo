package ru.netology.creditapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.creditapplication.dto.CreditResponse;
import ru.netology.creditapplication.service.CreditService;
import ru.netology.creditapplication.dto.CreditRequest;

@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping
    public ResponseEntity<Long> createCredit(@RequestBody CreditRequest request) {
        return ResponseEntity.ok(creditService.createCredit(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditResponse> getCredit(@PathVariable Long id) {
        return ResponseEntity.ok(creditService.getCredit(id));
    }
}
