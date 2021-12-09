package services;

import dao.ClientsDao;
import models.Clients;

import java.util.ArrayList;
import java.util.List;

public class ClientsService {
    static ClientsDao clientsDao;

    public ClientsService(ClientsDao clientsDao){this.clientsDao = clientsDao;}

    public List<Clients> getAllClients(){return clientsDao.getAllClients();}

    public static Clients getOneClient(Integer clientId) { return clientsDao.getOneClient(clientId);}

    public boolean createClient(Clients client) {
        if ((client.getClient_username().length()) > 50) {
            return false;
        }
        else if (client.getClient_firstname().length() > 50) {
            return false;
        }
        else if (client.getClient_lastname().length() > 50) {
            return false;
        }
        else {
            clientsDao.createClient(client);
            return true;
        }
    }

    public void updateClient(Integer clientId){
        clientsDao.updateClient(clientId);
    }

    public void deleteClient(Integer clientId) {clientsDao.deleteClient(clientId);}
}
