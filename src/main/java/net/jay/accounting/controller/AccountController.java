package net.jay.accounting.controller;

import net.jay.accounting.domain.*;
import net.jay.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户相关的操作：添加账户、查看账户信息、修改账户信息
 * Created by wangjie on 6/10/14 10:32 PM.
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 添加账户
    @RequestMapping("add")
    public String addAccountView(Model model) {

        model.addAttribute("owners", Owner.values());
        model.addAttribute("types", AccountType.values());
        model.addAttribute("subTypes", AccountSubType.values());

        return "account/add";
    }

    @RequestMapping("add-submit")
    public String addAccount(@RequestParam String name,
                             @RequestParam String desc,
                             @RequestParam Owner owner,
                             @RequestParam BigDecimal balance,
                             @RequestParam AccountType type,
                             @RequestParam AccountSubType subType,
                             Model model) {

        if (balance != null && balance.compareTo(BigDecimal.ZERO) < 0) {
            model.addAttribute("errMsg", "Illegal value for balance: " + balance);
            return "error";
        }

        Account account = new Account();
        account.setName(name);
        account.setDesc(desc);
        account.setOwner(owner);
        account.setBalance(balance);
        account.setAccountType(type);
        account.setSubType(subType);

        account.setAccountState(AccountState.NORMAL);  // default state

        accountService.addAccount(account);

        return "redirect:/account/list.htm";
    }


    // 查看某一个账户的信息
    @RequestMapping("detail")
    public String listAccount(@RequestParam String id,
                              Model model) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            model.addAttribute("errMsg", "account not exist: " + id);
            return "error";
        }

        model.addAttribute("account", account);

        return "account/detail";
    }


    // 查看所有账户信息：搜索字段，分页，排序
    @RequestMapping("list")
    public String listAccounts(Model model,
                               @RequestParam(required = false) String state) {

        List<Account> list = accountService.getAllAccounts();

        model.addAttribute("accounts", list);

        return "account/list";
    }


    // 修改某一个账户
    @RequestMapping("update")
    public String updateAccountView(@RequestParam String id, Model model) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            model.addAttribute("errMsg", "account not exist: " + id);
            return "error";
        }

        model.addAttribute("account", account);
        model.addAttribute("states", AccountState.values());

        return "account/update";
    }

    @RequestMapping("update-submit")
    public String updateAccount(Model model,
                                @RequestParam String id,
                                @RequestParam BigDecimal balance,
                                @RequestParam AccountState state) {

        Account account = accountService.getAccountById(id);

        if (account == null) {
            model.addAttribute("errMsg", "account not exist: " + id);
            return "error";
        }

        account.setAccountState(state);
        account.setBalance(balance);

        accountService.updateAccount(account);

        return "redirect:/account/detail.htm?id=" + id;
    }

}
