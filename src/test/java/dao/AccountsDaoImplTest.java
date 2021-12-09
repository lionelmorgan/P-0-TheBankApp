package dao;

import models.Accounts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountsDaoImplTest {

    AccountsDao accountsDao;

    public AccountsDaoImplTest() {
        this.accountsDao = new AccountsDaoImpl(H2Util.url, H2Util.username, H2Util.password);
    }

    @BeforeEach
    void setUp() {H2Util.createTable();}

    @AfterEach
    void tearDown() {H2Util.dropTable();}

    @BeforeAll
    static void beforeAll() {System.out.println("This will run before all tests");}

    @BeforeEach
    void beforeEach() {System.out.println("This will run before each test");}

    @Test
    void getAllAccountsIT() {
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

        accountsDao.createAccount(expectedResult.get(0));
        accountsDao.createAccount(expectedResult.get(1));
        accountsDao.createAccount(expectedResult.get(2));
        accountsDao.createAccount(expectedResult.get(3));
        accountsDao.createAccount(expectedResult.get(4));
        accountsDao.createAccount(expectedResult.get(5));
        accountsDao.createAccount(expectedResult.get(6));
        accountsDao.createAccount(expectedResult.get(7));
        accountsDao.createAccount(expectedResult.get(8));
        accountsDao.createAccount(expectedResult.get(9));
        accountsDao.createAccount(expectedResult.get(10));
        accountsDao.createAccount(expectedResult.get(11));
        accountsDao.createAccount(expectedResult.get(12));
        accountsDao.createAccount(expectedResult.get(13));
        accountsDao.createAccount(expectedResult.get(14));
        accountsDao.createAccount(expectedResult.get(15));
        accountsDao.createAccount(expectedResult.get(16));
        accountsDao.createAccount(expectedResult.get(17));
        accountsDao.createAccount(expectedResult.get(18));
        accountsDao.createAccount(expectedResult.get(19));
        accountsDao.createAccount(expectedResult.get(20));
        accountsDao.createAccount(expectedResult.get(21));
        accountsDao.createAccount(expectedResult.get(22));
        accountsDao.createAccount(expectedResult.get(23));
        accountsDao.createAccount(expectedResult.get(24));
        accountsDao.createAccount(expectedResult.get(25));

        List<Accounts> actualResult = accountsDao.getAllAccounts();

        assertEquals(expectedResult.toString(), actualResult.toString());
    }
}

    /*void getAccountIT() {
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

        accountsDao.createAccount(expectedResult.get(0));
        accountsDao.createAccount(expectedResult.get(1));
        accountsDao.createAccount(expectedResult.get(2));
        accountsDao.createAccount(expectedResult.get(3));
        accountsDao.createAccount(expectedResult.get(4));
        accountsDao.createAccount(expectedResult.get(5));
        accountsDao.createAccount(expectedResult.get(6));
        accountsDao.createAccount(expectedResult.get(7));
        accountsDao.createAccount(expectedResult.get(8));
        accountsDao.createAccount(expectedResult.get(9));
        accountsDao.createAccount(expectedResult.get(10));
        accountsDao.createAccount(expectedResult.get(11));
        accountsDao.createAccount(expectedResult.get(12));
        accountsDao.createAccount(expectedResult.get(13));
        accountsDao.createAccount(expectedResult.get(14));
        accountsDao.createAccount(expectedResult.get(15));
        accountsDao.createAccount(expectedResult.get(16));
        accountsDao.createAccount(expectedResult.get(17));
        accountsDao.createAccount(expectedResult.get(18));
        accountsDao.createAccount(expectedResult.get(19));
        accountsDao.createAccount(expectedResult.get(20));
        accountsDao.createAccount(expectedResult.get(21));
        accountsDao.createAccount(expectedResult.get(22));
        accountsDao.createAccount(expectedResult.get(23));
        accountsDao.createAccount(expectedResult.get(24));
        accountsDao.createAccount(expectedResult.get(25));

        List<Accounts> actualResult = accountsDao.getAccount(1);

        assertEquals(expectedResult.toString(), actualResult.toString());
    }*/


    /*@Test
        void deleteClientIT(){
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

            accountsDao.createAccount(expectedResult.get(0));
            accountsDao.createAccount(expectedResult.get(1));
            accountsDao.createAccount(expectedResult.get(2));
            accountsDao.createAccount(expectedResult.get(3));
            accountsDao.createAccount(expectedResult.get(4));
            accountsDao.createAccount(expectedResult.get(5));
            accountsDao.createAccount(expectedResult.get(6));
            accountsDao.createAccount(expectedResult.get(7));
            accountsDao.createAccount(expectedResult.get(8));
            accountsDao.createAccount(expectedResult.get(9));
            accountsDao.createAccount(expectedResult.get(10));
            accountsDao.createAccount(expectedResult.get(11));
            accountsDao.createAccount(expectedResult.get(12));
            accountsDao.createAccount(expectedResult.get(13));
            accountsDao.createAccount(expectedResult.get(14));
            accountsDao.createAccount(expectedResult.get(15));
            accountsDao.createAccount(expectedResult.get(16));
            accountsDao.createAccount(expectedResult.get(17));
            accountsDao.createAccount(expectedResult.get(18));
            accountsDao.createAccount(expectedResult.get(19));
            accountsDao.createAccount(expectedResult.get(20));
            accountsDao.createAccount(expectedResult.get(21));
            accountsDao.createAccount(expectedResult.get(22));
            accountsDao.createAccount(expectedResult.get(23));
            accountsDao.createAccount(expectedResult.get(24));
            accountsDao.createAccount(expectedResult.get(25));

            accountsDao.deleteAccount(15);
            expectedResult.remove(14);

            List<Accounts> actualResult = accountsDao.getAllAccounts();

            assertEquals(expectedResult.toString(), actualResult.toString());
            assertNull(accountsDao.getAccount(15));
        }*/



