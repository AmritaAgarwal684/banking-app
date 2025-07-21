package com.project.banking.service;

import com.project.banking.entity.Account;
import com.project.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id){
        return accountRepository.findById(id);
    }

    public Account deposit(Long id,double amount){
        Account account = getAccount(id).orElseThrow(()-> new RuntimeException("Account id is not available"))  ;
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        return account;
    }

    public Account withDraw(Long id,double amount){
        Account account = getAccount(id).orElseThrow(()-> new RuntimeException("Account id is not correct"));
        if(account.getBalance() >= amount){
            account.setBalance(account.getBalance()- amount);
        }
        else
            throw new RuntimeException("Insufficient balance");
        accountRepository.save(account);
        return account;
    }
}
