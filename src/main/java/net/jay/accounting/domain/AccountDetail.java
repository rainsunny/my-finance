package net.jay.accounting.domain;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Account detail bean
 * Created by wangjie on 6/8/14 5:02 PM.
 */
public class AccountDetail {

    public static final int DEBIT = 0; // 出账
    public static final int CREDIT = 1; // 进账


    private long detailId;

    private String accountId;
    private int debitOrCredit;

    private BigDecimal operationAmount;
    private BigDecimal accountBalance;

    private Date createTime;
    private Date updateTime;


}
