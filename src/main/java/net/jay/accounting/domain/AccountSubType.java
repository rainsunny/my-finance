package net.jay.accounting.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangjie
 * @date 6/23/14
 */
public enum AccountSubType {

    // assets
    CASH("现金"),
    RECEIVABLE("待收款"),
    FUNDS("基金"),
    EQUIPMENT("设备"),

    // liabilities
    PAYABLE("待付款"),

    // equity
    EXPENSES("花费"),
    REVENUES("营收");

    private String desc;

    AccountSubType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static Map<AccountType, List<AccountSubType>> subMap = new HashMap<>();

    static {
        subMap.put(AccountType.ASSETS, Arrays.asList(CASH, EQUIPMENT, FUNDS, RECEIVABLE));
        subMap.put(AccountType.LIABILITIES, Arrays.asList(PAYABLE));
        subMap.put(AccountType.EQUITY, Arrays.asList(EXPENSES, REVENUES));
    }
}
