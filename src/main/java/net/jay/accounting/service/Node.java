package net.jay.accounting.service;

import net.jay.accounting.domain.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjie on 6/11/14 8:07 PM.
 */
public class Node {

    public Account account;
    public int level;
    public List<Node> nodeList = new ArrayList<>();

    public Node(Account account, int level) {
        this.account = account;
        this.level = level;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        if (account != null) {

            builder.append(String.format("<div class=\"level_%d\">" +
                    "<a href=\"/accounts/%s\" target=\"_blank\">%s</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "<span class=\"rmb\">%,.2f</span>" +
                    "</div>\n", level, account.getId(), account.getName(), account.getBalance().doubleValue()));
        }

        for (Node node : nodeList) {

            builder.append(node.toString());
        }


        return builder.toString();
    }

    private String repeat(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }
}
