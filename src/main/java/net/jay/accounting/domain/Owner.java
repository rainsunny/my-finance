package net.jay.accounting.domain;

/**
 * @author wangjie
 * @date 6/24/14
 */
public enum Owner {

    ME("我"),
    MOM("妈");

    private String desc;

    Owner(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
