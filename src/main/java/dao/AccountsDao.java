package dao;

import models.Accounts;
import java.util.List;

public interface AccountsDao {
    List<Accounts> getAllAccounts();
    List<Accounts> getAccount(Integer clientId);
    List<Accounts> getAccountExact(Integer clientId);
    List<Accounts> getAccountRange(Integer clientId);
    void createAccount(Accounts account);
    void updateAccount(Accounts account);
    void deleteAccount(Accounts account);
    void withdrawFromAccount(Accounts account);
    void transferToAccount(Accounts account);
}
