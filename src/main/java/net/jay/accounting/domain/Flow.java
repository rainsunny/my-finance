package net.jay.accounting.domain;

/**
 * @author wangjie
 * @date 6/28/14
 */
public enum Flow {

    DEBIT("出账"),
    CREDIT("进账");

    private String desc;

    Flow(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
