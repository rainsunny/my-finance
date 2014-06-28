package net.jay.accounting.persistence;

import net.jay.accounting.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangjie on 6/12/14 10:40 PM.
 */
public interface AccountMapper {

    int insertAccount(Account account);

    Account getAccount(String accountId);

    List<Account> getAccountsBy(@Param("type")String type, @Param("state")String state);

    int updateAccount(Account account);
}
