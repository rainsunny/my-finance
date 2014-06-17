package net.jay.accounting.persistence;

import net.jay.accounting.domain.AccountDetail;

import java.sql.Date;
import java.util.List;

/**
 * Created by wangjie on 6/12/14 10:42 PM.
 */
public interface AccountDetailMapper {

    int insertAccountDetail(AccountDetail accountDetail);

    List<AccountDetail> getAccountDetailsDuring(Date startTime, Date endTime);

    List<AccountDetail> getAccountDetailSince(Date startTime);

    int deleteAccountDetail(String detailId);
}
