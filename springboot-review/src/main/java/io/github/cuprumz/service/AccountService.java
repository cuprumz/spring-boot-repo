package io.github.cuprumz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.github.cuprumz.dao.AccountRepository;
import io.github.cuprumz.model.Account;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(Account source, Account target, float amounts) {
        source.setBalance(source.getBalance() - amounts);
        target.setBalance(target.getBalance() + amounts);

        accountRepository.updateBalanceById(source.getBalance(), source.getId());
        accountRepository.updateBalanceById(target.getBalance(), target.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transferException(Account source, Account target, float amounts) {
        source.setBalance(source.getBalance() - amounts);
        target.setBalance(target.getBalance() + amounts);

        accountRepository.updateBalanceById(source.getBalance(), source.getId());
        int i = 1 / 0;
        accountRepository.updateBalanceById(target.getBalance(), target.getId());
    }
}
