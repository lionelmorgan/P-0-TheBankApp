package services;

import dao.AccountsDao;
import dao.AccountsDaoImpl;
import dao.ClientsDao;
import models.Accounts;

import java.util.List;

public class AccountsService {
    static AccountsDao accountsDao;

    public AccountsService(AccountsDao accountsDao){this.accountsDao = accountsDao;}

    public List<Accounts> getAccount(Integer clientId) {return accountsDao.getAccount(clientId);}

    public List<Accounts> getAccountRange(Integer clientId) {return accountsDao.getAccountRange(clientId);}

    public List<Accounts> getAccountExact(Integer clientId) {return accountsDao.getAccountExact(clientId);}

    public List<Accounts> getAllAccounts() {return accountsDao.getAllAccounts();}

    public boolean createAccount(Accounts account) {
        if (account.getClient_username().length() > 50)
            return false;
        else if (account.getClient_firstname().length() > 50)
            return false;
        else if (account.getClient_lastname().length() > 50)
            return false;
        else if (account.getAccount_balance() < 0)
            return false;
        accountsDao.createAccount(account);
        return true;
    }
    public void updateAccount(Accounts account){
        accountsDao.updateAccount(account);
    }

    public void deleteAccount(Accounts account) { accountsDao.deleteAccount(account);}

    public void withdrawFromAccount(Accounts account){ accountsDao.withdrawFromAccount(account);}

}
