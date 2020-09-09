package io.github.cuprumz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.github.cuprumz.dao.AccountRepository;
import io.github.cuprumz.model.Account;
import io.github.cuprumz.service.AccountService;

@SpringBootTest
public class TransactionTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Test
    public void init() {
        float init = 5000F;
        System.out.println(accountRepository);
        accountRepository.deleteAll();
        Account source = new Account(1L, init), target = new Account(2L, init);
        accountRepository.save(source);
        accountRepository.save(target);
        assertEquals(init, accountRepository.findById(1L).get().getBalance(), "ok");
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void test1() {
        Account source = accountRepository.findById(1L).get(), target = accountRepository.findById(2L).get();

        accountService.transfer(source, target, 2000F);
        accountService.transferException(source, target, 2000F);
        int i = 1 / 0;
    }
}
