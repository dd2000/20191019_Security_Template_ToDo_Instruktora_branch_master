package com.j24.security.template.service;

import com.j24.security.template.model.Account;
import com.j24.security.template.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public void removeAccount(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();

            if (!account.isAdmin()) {
                accountRepository.delete(account);
            }
        }
    }

    public void toggleLock(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();

            account.setLocked(!account.isLocked());

            accountRepository.save(account);
        }
    }
}
