package com.project.banking.controller;

import com.project.banking.entity.Account;
import com.project.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
    }

    @GetMapping("/deposit")
    public ResponseEntity<Account> makeDeposit(Long id,double balance){
        return new ResponseEntity<>(accountService.deposit(id,balance), HttpStatus.OK);
    }

    @GetMapping("/withdraw")
    public ResponseEntity<Account> withDraw(Long id, double balance){
        return new ResponseEntity<>(accountService.withDraw(id,balance), HttpStatus.OK);
    }
}
