package net.jay.accounting.service;

import net.jay.accounting.domain.Account;
import net.jay.accounting.persistence.AccountMapper;
import net.jay.accounting.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public void fetchAllAccounts() {

    }

    public String getAccountList() {

        List<Account> list = getAccountsByTypeState(null, Account.NORMAL_STATE);


        Node root = new Node(null, 0);

        List<Node> nodes = Arrays.asList(root);

        int level = 1;

        while (!list.isEmpty() && !nodes.isEmpty()) {

            nodes = attach(nodes, list, level);
            level++;
        }

        return root.toString();
    }

    private List<Node> attach(List<Node> nodes, List<Account> accounts, int level) {

        List<Node> result = new ArrayList<>();

        for (Node node : nodes) {
            result.addAll(attachOne(node, accounts, level));
        }

        return result;
    }


    private List<Node> attachOne(Node node, List<Account> accounts, int level) {

        Iterator<Account> iterator = accounts.iterator();

        while (iterator.hasNext()) {

            Account account = iterator.next();

            if (isParentOf(node.account, account)) {
                node.nodeList.add(new Node(account, level));
                iterator.remove();
            }
        }

        return node.nodeList;
    }

    private boolean isParentOf(Account a, Account b) {
        return b != null && (a == null ? StringUtils.isBlank(b.getParentId()) : b.getParentId().equals(a.getId()));
    }


    public List<Account> getAccountsByTypeState(String type, String state) {

        return accountMapper.getAccountsBy(type, state);
    }

    public String generateId() {
        long seqNextVal = accountMapper.accountSeqNextVal();
        return DateUtil.formatDate(new Date(), DateUtil.YYYYMMDD) + seqNextVal;
    }

    public void addAccount(Account account) {

        accountMapper.insertAccount(account);
    }

    public void removeAccount(String accountId) {
        accountMapper.deleteAccount(accountId);
    }

    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }

}
