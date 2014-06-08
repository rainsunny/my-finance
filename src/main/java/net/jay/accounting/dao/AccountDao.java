package net.jay.accounting.dao;

import net.jay.accounting.service.Account;
import net.jay.accounting.utils.DatabaseUtil;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Account dao
 * Created by wangjie on 6/8/14 4:52 PM.
 */
@Repository
public class AccountDao {

    private Connection conn;

    public int insertAccount(Account account) throws SQLException, IOException {

        String sql = "insert into tb_account (account_id, name, desc, balance, parent_id, account_type, create_time, account_state) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DatabaseUtil.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getId());
            ps.setString(2, account.getName());
            ps.setString(3, account.getDesc());
            ps.setBigDecimal(4, account.getBalance());
            ps.setString(5, account.getParentId());
            ps.setString(6, account.getAccountType());
            ps.setDate(7, account.getCreateTime());
            ps.setString(8, account.getAccountState());

            return ps.executeUpdate();

        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

    public Account getAccount(String accountId) throws SQLException, IOException {

        String sql = "select account_id, account_name, desc, balance, parent_id, account_type, create_time, update_time, account_state from tb_account where account_id = ?";

        try {
            conn = DatabaseUtil.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);

            ResultSet rs = ps.executeQuery();

            Account account = null;

            while (rs.next()) {

                account = new Account();

                account.setId(rs.getString(1));
                account.setName(rs.getString(2));
                account.setDesc(rs.getString(3));
                account.setBalance(rs.getBigDecimal(4));
                account.setParentId(rs.getString(5));
                account.setAccountType(rs.getString(6));
                account.setCreateTime(rs.getDate(7));
                account.setUpdateTime(rs.getDate(8));
                account.setAccountState(rs.getString(9));

            }

            return account;

        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
