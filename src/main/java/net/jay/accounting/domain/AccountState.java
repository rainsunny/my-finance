package net.jay.accounting.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjie
 * @date 6/23/14
 */
public enum  AccountState {

    NORMAL("正常"),
    NOT_ACTIVE("停用");

    private String desc;

    AccountState(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
