package net.jay.accounting.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Account bean
 * Created by wangjie on 6/8/14 4:55 PM.
 */
public class Account {

    // ACCOUNT TYPE
    public static final String LEAF_ACCOUNT = "LEAF";
    public static final String INNER_ACCOUNT = "INNER";

    // ACCOUNT STATE
    public static final String NORMAL_STATE = "NORMAL";
    public static final String NOT_USE_STATE = "NOT_USE";

    public Account(String id, String pId) {
        this.id = id;
        this.parentId = pId;
    }

    public Account() {}

    private String name;
    private String id;
    private String desc;

    private String parentId;  // 父账户ID
    private String parentName;  // 父账户名称

    private BigDecimal balance;
    private String accountType;  // 是否叶子节点
    private String accountState; // 是否禁用

    private Date createTime;
    private Date updateTime;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }
}
