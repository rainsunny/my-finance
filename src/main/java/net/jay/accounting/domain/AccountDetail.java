package net.jay.accounting.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Account detail bean
 * Created by wangjie on 6/8/14 5:02 PM.
 */
public class AccountDetail {

    private long detailId;

    private String accountId;
    private Flow flow;

    private BigDecimal operationAmount;
    private BigDecimal accountBalance;

    private Date createTime;
    private Date updateTime;


}
