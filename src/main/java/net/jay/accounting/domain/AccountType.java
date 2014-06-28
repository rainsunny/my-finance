package net.jay.accounting.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjie
 * @date 6/23/14
 */
public enum AccountType {

    ASSETS("资产"),
    LIABILITIES("负债"),
    EQUITY("权益");

    private String desc;

    AccountType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
