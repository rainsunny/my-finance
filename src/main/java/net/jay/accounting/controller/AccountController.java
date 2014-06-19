package net.jay.accounting.controller;

import net.jay.accounting.domain.Account;
import net.jay.accounting.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 账户相关的操作：添加账户、查看账户信息、修改账户信息
 *
 * Created by wangjie on 6/10/14 10:32 PM.
 */

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 添加账户
    @RequestMapping("/account/add.htm")
    public String addAccountView(Model model) {

        List<Account> innerAccounts = accountService.getAccountsByTypeState(Account.INNER_ACCOUNT, Account.NORMAL_STATE);

        model.addAttribute("accounts", innerAccounts);

        return "account/add";
    }

    @RequestMapping("/account/add-submit.htm")
    public String addAccount(@RequestParam String name,
                             @RequestParam String desc,
                             @RequestParam String parentId,
                             @RequestParam BigDecimal balance,
                             @RequestParam String accountType,
                             Model model) {

        // check required params
        if (StringUtils.isBlank(name) || StringUtils.isBlank(desc) || StringUtils.isBlank(accountType)) {
            model.addAttribute("errMsg", "Required parameters missing");
            return "error";
        }

        if (!accountType.equals(Account.INNER_ACCOUNT) && !accountType.equals(Account.LEAF_ACCOUNT)) {
            model.addAttribute("errMsg", "Illegal value for accountType: " + accountType);
            return "error";
        }

        if (balance != null && balance.compareTo(BigDecimal.ZERO) < 0) {
            model.addAttribute("errMsg", "Illegal value for balance: " + balance);
            return "error";
        }

        if (StringUtils.isNotBlank(parentId)) {
            Account parentAccount = accountService.getAccountById(parentId);
            if (parentAccount == null) {
                model.addAttribute("errMsg", "Illegal value for parentId: " + parentId);
                return "error";
            }
        }

        Account account = new Account();
        account.setName(name);
        account.setDesc(desc);
        account.setAccountType(accountType);

        account.setAccountState(Account.NORMAL_STATE);  // default state

        if (StringUtils.isNotBlank(parentId)) account.setParentId(parentId); // can have no parent id

        account.setBalance(balance == null ? BigDecimal.ZERO : balance);

        account.setCreateTime(new Date(System.currentTimeMillis()));

        String id = accountService.generateId();
        account.setId(id);

        accountService.addAccount(account);

        return "redirect:/account?id=" + id;
    }


    // 查看某一个账户的信息
    @RequestMapping("/account")
    public String listAccount(@RequestParam String id, Model model) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            model.addAttribute("errMsg", "account not exist: " + id);
            return "error";
        }

        model.addAttribute("account", account);

        return "account/detail";
    }


    // 查看所有账户信息
    @RequestMapping("/account/list")
    public String listAccounts(Model model) {

        String accountsHtml = accountService.getAccountList();

        model.addAttribute("accounts", accountsHtml);

        return "account/list";
    }


    // 修改某一个账户
    @RequestMapping("/account/update")
    public String updateAccountView(@RequestParam String id, Model model) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            model.addAttribute("errMsg", "account not exist: " + id);
            return "error";
        }

        model.addAttribute("account", account);

        List<Account> innerAccounts = accountService.getAccountsByTypeState(Account.INNER_ACCOUNT, Account.NORMAL_STATE);

        model.addAttribute("parents", innerAccounts);

        return "account/update";
    }

    @RequestMapping("/account/update-submit")
    public String updateAccount(Model model,
                                @RequestParam String accountId,
                                @RequestParam String name,
                                @RequestParam String desc,
                                @RequestParam String parentId,
                                @RequestParam BigDecimal balance,
                                @RequestParam String accountType,
                                @RequestParam String accountState) {

        Account account = accountService.getAccountById(accountId);

        if (account == null) {
            model.addAttribute("errMsg", "account not exist: " + accountId);
            return "error";
        }

        if (StringUtils.isNotBlank(name)) {
            account.setName(name);
        }

        if (StringUtils.isNotBlank(desc)) {
            account.setDesc(desc);
        }

        if (StringUtils.isNotBlank(parentId)) {
            account.setParentId(parentId);
        }

        if (balance != null) {
            account.setBalance(balance);
        }

        if (StringUtils.isNotBlank(accountType)) {
            account.setAccountType(accountType);
        }

        if (StringUtils.isNotBlank(accountState)) {
            account.setAccountState(accountState);
        }

        account.setUpdateTime(new Date(System.currentTimeMillis()));

        accountService.updateAccount(account);

        return "redirect:/account?id=" + accountId;
    }

}
