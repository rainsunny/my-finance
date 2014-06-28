package net.jay.accounting.domain;

/**
 * @author wangjie
 * @date 6/28/14
 */
public enum TransferType {

    BOTH_INCREASE("同增"),
    BOTH_DECREASE("同减"),
    TRANSFER("转账");

    private String desc;

    TransferType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
