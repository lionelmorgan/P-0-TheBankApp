package dao;

import models.Clients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



public class ClientsDaoImplTest {

        ClientsDao clientsDao;

        public ClientsDaoImplTest(){
            this.clientsDao = new ClientsDaoImpl(H2Util.url,H2Util.username, H2Util.password);
        }

        @BeforeEach
        void setUp() {
            H2Util.createTable();
        }

        @AfterEach
        void tearDown() {
            H2Util.dropTable();
        }

        @BeforeAll
        static void beforeAll(){
            System.out.println("This will run before all tests");

        }
        @BeforeEach
        void beforeEach(){
            System.out.println("This will run before each test");
        }

        @Test
        void getAllClientsIT(){

                List<Clients> expectedResult = new ArrayList<>();
                expectedResult.add(new Clients(1, "alennox@dreamville.com", "Ari", "Lennox"));
                expectedResult.add(new Clients(2, "cbailey24@yahoo.com", "Champ", "Bailey"));
                expectedResult.add(new Clients(3, "dnowitzki@dallasmavs.net", "Dirk", "Nowitzki"));
                expectedResult.add(new Clients(4, "emusk@spacex.com", "Elon", "Musk"));
                expectedResult.add(new Clients(5, "jbrown@soulmail.com", "James", "Brown"));
                expectedResult.add(new Clients(6, "jcole@dreamville.com", "Jermaine", "Cole"));
                expectedResult.add(new Clients(7, "ljames@lalakers.com", "Lebron", "James"));
                expectedResult.add(new Clients(8, "lrichie@outlook.com", "Lionel", "Richie"));
                expectedResult.add(new Clients(9, "mjackson@astromail.com", "Michael", "Jackson"));
                expectedResult.add(new Clients(10, "mjordan@spacemail.net", "Michael", "Jordan"));
                expectedResult.add(new Clients(11, "nosaka@olympics.com", "Naomi", "Osaka"));
                expectedResult.add(new Clients(12, "obrown@thatsoraven.net", "Orlando", "Brown"));
                expectedResult.add(new Clients(13, "pgeorge@clippers.com", "Paul", "George"));
                expectedResult.add(new Clients(14, "eqelizabeth@england.eng", "Queen", "Elizabeth"));
                expectedResult.add(new Clients(15, "rmoss@patriots.com", "Randy", "Moss"));
                expectedResult.add(new Clients(16, "kbryant@lalakers.com", "Kobe", "Bryant"));

                clientsDao.createClient(expectedResult.get(0));
                clientsDao.createClient(expectedResult.get(1));
                clientsDao.createClient(expectedResult.get(2));
                clientsDao.createClient(expectedResult.get(3));
                clientsDao.createClient(expectedResult.get(4));
                clientsDao.createClient(expectedResult.get(5));
                clientsDao.createClient(expectedResult.get(6));
                clientsDao.createClient(expectedResult.get(7));
                clientsDao.createClient(expectedResult.get(8));
                clientsDao.createClient(expectedResult.get(9));
                clientsDao.createClient(expectedResult.get(10));
                clientsDao.createClient(expectedResult.get(11));
                clientsDao.createClient(expectedResult.get(12));
                clientsDao.createClient(expectedResult.get(13));
                clientsDao.createClient(expectedResult.get(14));
                clientsDao.createClient(expectedResult.get(15));

                List<Clients> actualResult = clientsDao.getAllClients();

                assertEquals(expectedResult.toString(), actualResult.toString());
            }

        @Test
        void getOneClientIT(){
            List<Clients> expectedResult = new ArrayList<>();
            expectedResult.add(new Clients(1, "alennox@dreamville.com", "Ari", "Lennox"));
            expectedResult.add(new Clients(2, "cbailey24@yahoo.com", "Champ", "Bailey"));
            expectedResult.add(new Clients(3, "dnowitzki@dallasmavs.net", "Dirk", "Nowitzki"));
            expectedResult.add(new Clients(4, "emusk@spacex.com", "Elon", "Musk"));
            expectedResult.add(new Clients(5, "jbrown@soulmail.com", "James", "Brown"));
            expectedResult.add(new Clients(6, "jcole@dreamville.com", "Jermaine", "Cole"));
            expectedResult.add(new Clients(7, "ljames@lalakers.com", "Lebron", "James"));
            expectedResult.add(new Clients(8, "lrichie@outlook.com", "Lionel", "Richie"));
            expectedResult.add(new Clients(9, "mjackson@astromail.com", "Michael", "Jackson"));
            expectedResult.add(new Clients(10, "mjordan@spacemail.net", "Michael", "Jordan"));
            expectedResult.add(new Clients(11, "nosaka@olympics.com", "Naomi", "Osaka"));
            expectedResult.add(new Clients(12, "obrown@thatsoraven.net", "Orlando", "Brown"));
            expectedResult.add(new Clients(13, "pgeorge@clippers.com", "Paul", "George"));
            expectedResult.add(new Clients(14, "eqelizabeth@england.eng", "Queen", "Elizabeth"));
            expectedResult.add(new Clients(15, "rmoss@patriots.com", "Randy", "Moss"));
            expectedResult.add(new Clients(16, "kbryant@lalakers.com", "Kobe", "Bryant"));

            clientsDao.createClient(expectedResult.get(0));
            clientsDao.createClient(expectedResult.get(1));
            clientsDao.createClient(expectedResult.get(2));
            clientsDao.createClient(expectedResult.get(3));
            clientsDao.createClient(expectedResult.get(4));
            clientsDao.createClient(expectedResult.get(5));
            clientsDao.createClient(expectedResult.get(6));
            clientsDao.createClient(expectedResult.get(7));
            clientsDao.createClient(expectedResult.get(8));
            clientsDao.createClient(expectedResult.get(9));
            clientsDao.createClient(expectedResult.get(10));
            clientsDao.createClient(expectedResult.get(11));
            clientsDao.createClient(expectedResult.get(12));
            clientsDao.createClient(expectedResult.get(13));
            clientsDao.createClient(expectedResult.get(14));
            clientsDao.createClient(expectedResult.get(15));

            Clients actualResult = clientsDao.getOneClient(7);


            assertEquals(expectedResult.get(6).toString(), actualResult.toString());

        }

        @Test
        void createClientIT(){
            List<Clients> expectedResult = new ArrayList<>();
            expectedResult.add(new Clients(1, "alennox@dreamville.com", "Ari", "Lennox"));
            expectedResult.add(new Clients(2, "cbailey24@yahoo.com", "Champ", "Bailey"));
            expectedResult.add(new Clients(3, "dnowitzki@dallasmavs.net", "Dirk", "Nowitzki"));
            expectedResult.add(new Clients(4, "emusk@spacex.com", "Elon", "Musk"));
            expectedResult.add(new Clients(5, "jbrown@soulmail.com", "James", "Brown"));
            expectedResult.add(new Clients(6, "jcole@dreamville.com", "Jermaine", "Cole"));
            expectedResult.add(new Clients(7, "ljames@lalakers.com", "Lebron", "James"));
            expectedResult.add(new Clients(8, "lrichie@outlook.com", "Lionel", "Richie"));
            expectedResult.add(new Clients(9, "mjackson@astromail.com", "Michael", "Jackson"));
            expectedResult.add(new Clients(10, "mjordan@spacemail.net", "Michael", "Jordan"));
            expectedResult.add(new Clients(11, "nosaka@olympics.com", "Naomi", "Osaka"));
            expectedResult.add(new Clients(12, "obrown@thatsoraven.net", "Orlando", "Brown"));
            expectedResult.add(new Clients(13, "pgeorge@clippers.com", "Paul", "George"));
            expectedResult.add(new Clients(14, "eqelizabeth@england.eng", "Queen", "Elizabeth"));
            expectedResult.add(new Clients(15, "rmoss@patriots.com", "Randy", "Moss"));
            expectedResult.add(new Clients(16, "kbryant@lalakers.com", "Kobe", "Bryant"));

            clientsDao.createClient(expectedResult.get(0));
            clientsDao.createClient(expectedResult.get(1));
            clientsDao.createClient(expectedResult.get(2));
            clientsDao.createClient(expectedResult.get(3));
            clientsDao.createClient(expectedResult.get(4));
            clientsDao.createClient(expectedResult.get(5));
            clientsDao.createClient(expectedResult.get(6));
            clientsDao.createClient(expectedResult.get(7));
            clientsDao.createClient(expectedResult.get(8));
            clientsDao.createClient(expectedResult.get(9));
            clientsDao.createClient(expectedResult.get(10));
            clientsDao.createClient(expectedResult.get(11));
            clientsDao.createClient(expectedResult.get(12));
            clientsDao.createClient(expectedResult.get(13));
            clientsDao.createClient(expectedResult.get(14));
            clientsDao.createClient(expectedResult.get(15));

            Integer actualResult = clientsDao.getAllClients().size();

            assertEquals(expectedResult.size(), actualResult);

        }
        //Revise
        /*@Test
        void updateClientIT(){

            Clients client = new Clients(12, "obrown@disney.net", "Orlando", "Brown");
            Clients expectedResult = new Clients(12, "obrown@thatsoraven.net", "Orlando", "Brown");
            clientsDao.createClient(client);

            clientsDao.updateClient(client.getClient_id());
            Clients actualResult = client;

            assertEquals(expectedResult, actualResult);

        }*/

        @Test
        void deleteClientIT(){
            List<Clients> expectedResult = new ArrayList<>();
            expectedResult.add(new Clients(1, "alennox@dreamville.com", "Ari", "Lennox"));
            expectedResult.add(new Clients(2, "cbailey24@yahoo.com", "Champ", "Bailey"));
            expectedResult.add(new Clients(3, "dnowitzki@dallasmavs.net", "Dirk", "Nowitzki"));
            expectedResult.add(new Clients(4, "emusk@spacex.com", "Elon", "Musk"));
            expectedResult.add(new Clients(5, "jbrown@soulmail.com", "James", "Brown"));
            expectedResult.add(new Clients(6, "jcole@dreamville.com", "Jermaine", "Cole"));
            expectedResult.add(new Clients(7, "ljames@lalakers.com", "Lebron", "James"));
            expectedResult.add(new Clients(8, "lrichie@outlook.com", "Lionel", "Richie"));
            expectedResult.add(new Clients(9, "mjackson@astromail.com", "Michael", "Jackson"));
            expectedResult.add(new Clients(10, "mjordan@spacemail.net", "Michael", "Jordan"));
            expectedResult.add(new Clients(11, "nosaka@olympics.com", "Naomi", "Osaka"));
            expectedResult.add(new Clients(12, "obrown@thatsoraven.net", "Orlando", "Brown"));
            expectedResult.add(new Clients(13, "pgeorge@clippers.com", "Paul", "George"));
            expectedResult.add(new Clients(14, "eqelizabeth@england.eng", "Queen", "Elizabeth"));
            expectedResult.add(new Clients(15, "rmoss@patriots.com", "Randy", "Moss"));
            expectedResult.add(new Clients(16, "kbryant@lalakers.com", "Kobe", "Bryant"));

            clientsDao.createClient(expectedResult.get(0));
            clientsDao.createClient(expectedResult.get(1));
            clientsDao.createClient(expectedResult.get(2));
            clientsDao.createClient(expectedResult.get(3));
            clientsDao.createClient(expectedResult.get(4));
            clientsDao.createClient(expectedResult.get(5));
            clientsDao.createClient(expectedResult.get(6));
            clientsDao.createClient(expectedResult.get(7));
            clientsDao.createClient(expectedResult.get(8));
            clientsDao.createClient(expectedResult.get(9));
            clientsDao.createClient(expectedResult.get(10));
            clientsDao.createClient(expectedResult.get(11));
            clientsDao.createClient(expectedResult.get(12));
            clientsDao.createClient(expectedResult.get(13));
            clientsDao.createClient(expectedResult.get(14));
            clientsDao.createClient(expectedResult.get(15));

            clientsDao.deleteClient(15);
            expectedResult.remove(14);

            List<Clients> actualResult = clientsDao.getAllClients();

            assertEquals(expectedResult.toString(), actualResult.toString());
            assertNull(clientsDao.getOneClient(15));
        }

}


