package net.jay.accounting.service;

import net.jay.accounting.domain.Account;
import net.jay.accounting.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjie on 6/8/14 6:22 PM.
 */
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountById(String accountId) {
        return accountMapper.getAccount(accountId);
    }

    public List<Account> getAllAccounts() {
        return accountMapper.getAccountsBy(null, null);
    }

    public void addAccount(Account account) {

        accountMapper.insertAccount(account);
    }

    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }

}
