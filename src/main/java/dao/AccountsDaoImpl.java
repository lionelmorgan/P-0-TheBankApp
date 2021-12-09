package dao;

import models.Accounts;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDaoImpl implements AccountsDao{

        String url;
        String username;
        String password;

        static Logger logger = Logger.getLogger(AccountsDaoImpl.class);

        public AccountsDaoImpl() {
            this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/capitaldatabase";
            this.username = System.getenv("RDS_USERNAME");
            this.password = System.getenv("RDS_PASSWORD");
        }

        public AccountsDaoImpl(String url, String username, String password) {
            this.url = url;
            this.username = username;
            this.password = password;
        }


        @Override
        public List<Accounts> getAllAccounts() {
            List<Accounts> accounts = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "SELECT * FROM accounts;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    accounts.add(new Accounts(rs.getInt(1), rs.getInt(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getDouble(6)));
                }
            } catch (SQLException a) {
                logger.error(a);
            }
            return accounts;

    }

    @Override
    public List<Accounts> getAccount(Integer clientId) {
            List<Accounts> client = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM accounts WHERE client_id = ?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, clientId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    client.add(new Accounts(rs.getInt(1), rs.getInt(2), rs.getString(3),
                            rs.getString(4), rs.getString(5), rs.getDouble(6)));
                }
                //conn.close();

            } catch (SQLException a) {
                logger.error(a);
            }
            return client;
        }
    @Override
    public List<Accounts> getAccountExact(Integer clientId) {
        List<Accounts> client = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM accounts WHERE client_id = ? AND account_no = 21;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                client.add(new Accounts(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }
            //conn.close();

        } catch (SQLException a) {
            logger.error(a);
        }
        return client;
    }
    @Override
    public List<Accounts> getAccountRange(Integer clientId) {
        List<Accounts> client = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM accounts WHERE client_id = ? AND account_balance BETWEEN 400 AND 2000;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                client.add(new Accounts(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }
            //conn.close();

        } catch (SQLException a) {
            logger.error(a);
        }
        return client;
    }

    @Override
    public void createAccount(Accounts account) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO accounts VALUES (DEFAULT, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account.getClient_id());
            ps.setString(2, account.getClient_username());
            ps.setString(3, account.getClient_firstname());
            ps.setString(4, account.getClient_lastname());
            ps.setDouble(5, account.getAccount_balance());

            ps.executeUpdate();

            //conn.close();

        } catch (SQLException a) {
            logger.error(a);
        }

    }

    @Override
    public void updateAccount(Accounts account) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE accounts SET client_username = ? WHERE account_no = ? AND client_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getClient_username());
            ps.setInt(2, account.getAccount_no());
            ps.setInt(3, account.getClient_id());
            ps.executeUpdate();

            //conn.close();

        } catch (SQLException a) {
            logger.error(a);
        }

    }

    @Override
    public void deleteAccount(Accounts account) {

            try( Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM accounts WHERE account_no = ? AND client_id = ?;";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setInt(1, account.getAccount_no());
                ps.setInt(2, account.getClient_id());

                ps.executeUpdate();

            }catch (SQLException a) {
                logger.error(a);
            }
        }

    @Override
    public void withdrawFromAccount(Accounts account) {

        try( Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE accounts SET account_withdraw = ?, account_balance = (account_balance - ?) WHERE account_no = ? AND client_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, account.getAccount_withdraw());
            ps.setDouble(2, account.getAccount_withdraw());
            ps.setInt(3, account.getAccount_no());
            ps.setInt(4, account.getClient_id());
            ps.executeUpdate();

            String sql1 = "INSERT INTO accounts VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, account.getAccount_no());
            ps1.setInt(2, account.getClient_id());
            ps1.setString(3, account.getClient_username());
            ps1.setString(4, account.getClient_firstname());
            ps1.setString(5, account.getClient_lastname());
            ps1.setDouble(6, account.getAccount_balance());
            ps1.setDouble(7, account.getAccount_withdraw());
            ps1.executeUpdate();


        }catch (SQLException a) {
            logger.error(a);
        }


    }

    @Override
    public void transferToAccount(Accounts account) {

        try( Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE accounts SET account_balance = (account_balance - ?) WHERE account_no = ? AND client_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, account.getAccount_transfer());
            ps.setInt(2, account.getAccount_no());
            ps.setInt(3, account.getClient_id());
            ps.executeUpdate();

            String sql1 = "UPDATE accounts SET account_balance = (account_balance + ?) WHERE account_no = ? AND client_id = ?;";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, account.getAccount_transfer());
            ps1.setInt(2, account.getAccount_no());
            ps1.setInt(3, account.getClient_id());
            ps1.executeUpdate();

        }catch (SQLException a) {
            logger.error(a);
        }


    }
    }

