package net.jay.accounting.domain;

import java.math.BigDecimal;

/**
 * @author wangjie
 * @date 6/28/14
 */
public class FundTransfer {

    private String id;
    private String srcAccountId;
    private String dstAccountId;
    private TransferType transferType;
    private BigDecimal opAmount;

}
