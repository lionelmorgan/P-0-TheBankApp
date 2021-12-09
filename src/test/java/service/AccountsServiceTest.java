package service;

import dao.AccountsDao;
import models.Accounts;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.AccountsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountsServiceTest {

    static AccountsDao accountsDao = Mockito.mock(AccountsDao.class);

    AccountsService accountsService;

    public AccountsServiceTest() {this.accountsService = new AccountsService(accountsDao);}

    @Test
    void getAllAccounts(){
        List<Accounts> expectedResult = new ArrayList<>();
        expectedResult.add(new Accounts(1, 1, "alennox@dreamville.com", "Ari", "Lennox", 2835878.98));
        expectedResult.add(new Accounts(2, 2, "cbailey24@yahoo.com", "Champ", "Bailey", 24440594.77));
        expectedResult.add(new Accounts(3, 3, "dnowitzki@dallasmavs.net", "Dirk", "Nowitzki", 55702743.89));
        expectedResult.add(new Accounts(4, 4, "emusk@spacex.com", "Elon", "Musk", 4897432871.91));
        expectedResult.add(new Accounts(5, 5, "jbrown@soulmail.com", "James", "Brown", 2543499.35));
        expectedResult.add(new Accounts(6, 6, "jcole@dreamville.com", "Jermaine", "Cole", 42935678.99));
        expectedResult.add(new Accounts(7, 7, "ljames@lalakers.com", "Lebron", "James", 567543489.99));
        expectedResult.add(new Accounts(8, 8, "lrichie@outlook.com", "Lionel", "Richie", 1589.28));
        expectedResult.add(new Accounts(9, 9, "mali@worldboxing.net", "Muhammad", "Ali", 199876456.20));
        expectedResult.add(new Accounts(10, 9, "mali@worldboxing.net", "Muhammad", "Ali", 199876456.20));
        expectedResult.add(new Accounts(11, 9, "mali@worldboxing.net", "Muhammad", "Ali", 199876456.20));
        expectedResult.add(new Accounts(12, 9, "mali@worldboxing.net", "Muhammad", "Ali", 199876456.20));
        expectedResult.add(new Accounts(13, 10, "mjordan@spacemail.net", "Michael", "Jordan", 894235167.45));
        expectedResult.add(new Accounts(14, 10, "mjordan@spacemail.net", "Michael", "Jordan", 894235167.45));
        expectedResult.add(new Accounts(15, 10, "mjordan@spacemail.net", "Michael", "Jordan", 894235167.45));
        expectedResult.add(new Accounts(16, 11, "nosaka@olympics.com", "Naomi", "Osaka", 10134789.17));
        expectedResult.add(new Accounts(17, 12, "obrown@thatsoraven.net", "Orlando", "Brown", 2321165.25));
        expectedResult.add(new Accounts(18, 13, "pgeorge@clippers.com", "Paul", "George", 17899432.13));
        expectedResult.add(new Accounts(19, 14, "qelizabeth@england.eng", "Queen", "Elizabeth", 81942335167.99));
        expectedResult.add(new Accounts(20, 15, "rmoss@patriots.com", "Randy", "Moss", 29235167.45));
        expectedResult.add(new Accounts(21, 15, "rmoss@patriots.com", "Randy", "Moss", 9235167.45));
        expectedResult.add(new Accounts(22, 15, "rmoss@patriots.com", "Randy", "Moss", 235167.45));
        expectedResult.add(new Accounts(23, 15, "rmoss@patriots.com", "Randy", "Moss", 35167.45));
        expectedResult.add(new Accounts(24, 15, "rmoss@patriots.com", "Randy", "Moss", 5167.45));
        expectedResult.add(new Accounts(25, 15, "rmoss@patriots.com", "Randy", "Moss", 567.45));
        expectedResult.add(new Accounts(26, 15, "rmoss@patriots.com", "Randy", "Moss", 467.45));
        Mockito.when(accountsDao.getAllAccounts()).thenReturn(expectedResult);

        List<Accounts> actualResult = accountsDao.getAllAccounts();

        assertEquals(expectedResult.toString(), actualResult.toString());
    }
    @Test
    void getAccountRange(){
        List<Accounts> expectedResult = new ArrayList<>();
        expectedResult.add(new Accounts(8, 8, "lrichie@outlook.com", "Lionel", "Richie", 1589.28));
        expectedResult.add(new Accounts(25, 15, "rmoss@patriots.com", "Randy", "Moss", 567.45));
        expectedResult.add(new Accounts(26, 15, "rmoss@patriots.com", "Randy", "Moss", 467.45));

        List<Accounts> actualResult = new ArrayList<>();
        actualResult.add(new Accounts(8, 8, "lrichie@outlook.com", "Lionel", "Richie", 1589.28));
        actualResult.add(new Accounts(25, 15, "rmoss@patriots.com", "Randy", "Moss", 567.45));
        actualResult.add(new Accounts(26, 15, "rmoss@patriots.com", "Randy", "Moss", 467.45));


        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    void getAccountExact(){
        Accounts expectedResult = new Accounts(14, 10, "mjordan@spacemail.net", "Michael", "Jordan", 894235167.45);
        Mockito.when(accountsDao.getAccountExact(expectedResult.getClient_id())).thenReturn(Collections.singletonList((expectedResult)));

        List<Accounts> actualResult = accountsService.getAccountExact(expectedResult.getClient_id());

        assertEquals(expectedResult.toString(), actualResult.toString());
    }

    @Test
    void updateAccount(){
        Accounts account = new Accounts(17, 12, "obrown@thatsoraven.net", "Orlando", "Brown", 2321165.25);
        accountsService.updateAccount(account);
        Mockito.verify(accountsDao, Mockito.atLeastOnce()).updateAccount(account);

    }

    @Test
    void deleteAccount(){
        Accounts account = new Accounts(17, 12, "obrown@thatsoraven.net", "Orlando", "Brown", 2321165.25);
        accountsService.deleteAccount(account);
        Mockito.verify(accountsDao, Mockito.atLeastOnce()).deleteAccount(account);

    }

    @Test
    void withdrawFromAccount(){
        Accounts account = new Accounts(17, 12, "obrown@thatsoraven.net", "Orlando", "Brown", 2321165.25);
        accountsService.withdrawFromAccount(account);
        Mockito.verify(accountsDao, Mockito.atLeastOnce()).withdrawFromAccount(account);

    }

    @Test
    void transferToAccount(){
        Accounts account = new Accounts(21, 15, "rmoss@patriots.com", "Randy", "Moss", 9235167.45);
        accountsService.transferToAccount(account);
        Mockito.verify(accountsDao, Mockito.atLeastOnce()).transferToAccount(account);

    }

}

