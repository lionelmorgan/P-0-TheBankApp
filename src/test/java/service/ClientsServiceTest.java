package service;

import dao.ClientsDao;
import models.Clients;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.ClientsService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ClientsServiceTest {

    ClientsDao clientsDao = Mockito.mock(ClientsDao.class);

    ClientsService clientsService;

    public ClientsServiceTest(){this.clientsService = new ClientsService(clientsDao);}

    @Test
    void getAllClients(){
        //arrange
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
        expectedResult.add(new Clients(16, "khart@heartbeat.com", "Kevin", "Hart"));
        Mockito.when(clientsDao.getAllClients()).thenReturn(expectedResult);

        //act
        List<Clients> actualResult = clientsDao.getAllClients();


        //assert
        assertEquals(expectedResult.toString(), actualResult.toString());

    }

    @Test
    void getOneClient(){

        Clients expectedResult = new Clients(10, "mjordan@spacemail.net", "Michael", "Jordan");
        Mockito.when(clientsDao.getOneClient(expectedResult.getClient_id())).thenReturn(expectedResult);

        Clients actualResult = clientsService.getOneClient(expectedResult.getClient_id());

        assertEquals(expectedResult, actualResult);

    }
    //Revise
    @Test
    void createClientGreaterThan50(){
        Clients client = new Clients(1, "Is the client's username greater than 50 characters?",
                "Is the client firstname greater than 50 characters?", "Is the client last name greater than 50 characters?");
        //Boolean expectedResult = false;
        Boolean actualResult = clientsService.createClient(client);
        assertFalse(actualResult);
    }
    //Revise
    @Test
    void createClientLessThanOrEqualTo50IT(){
        Clients client = new Clients(1, "Is the client username less than 50 characters??",
                "Is the client firstname less than 50 characters?", "Is the client lastname less than 50 characters??");
        Boolean actualResult = clientsService.createClient(client);
        assertFalse(actualResult);
    }

    @Test
    void updateClient(){
        Integer clientId = 1;
        clientsService.updateClient(clientId);
        Mockito.verify(clientsDao, Mockito.atLeastOnce()).updateClient(clientId);

    }

    @Test
    void deleteClient(){
        Integer clientId = 1;
        clientsService.deleteClient(clientId);
        Mockito.verify(clientsDao, Mockito.atLeastOnce()).deleteClient(clientId);

    }
}



