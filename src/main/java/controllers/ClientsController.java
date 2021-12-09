package controllers;

import dao.ClientsDaoImpl;
import io.javalin.http.Context;
import models.Clients;
import services.ClientsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ClientsController {

    static ClientsService clientsService = new ClientsService(new ClientsDaoImpl());

    public static void getAllClients(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        List<Clients> clientsList = clientsService.getAllClients();
        String jsonString = new ObjectMapper().writeValueAsString(clientsList);
        context.status(200).result(jsonString);

    }

    public static void getOneClient(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        Integer clientId = Integer.parseInt(context.pathParam("id"));
        Clients client = ClientsService.getOneClient(clientId);
       if(clientsService.getOneClient(clientId) == null){
           context.status(404).result("No such client exists");
       }else {
           context.status(200).result(new ObjectMapper().writeValueAsString(client));
       }
    }

    public static void createClient(Context context) {
        Clients client = context.bodyAsClass(Clients.class);
        if (clientsService.createClient(client)) {
            context.status(201).result("Client created");

        } else {
            context.status(404).result("Client creation is more than 50 characters");
        }

    }

    public static void updateClient(Context context) {
        Clients client = context.bodyAsClass(Clients.class);
        Integer clientId = Integer.parseInt(context.pathParam("id"));
        clientsService.updateClient(clientId);
        context.status(201).result("Client with id of " + clientId + " has been updated successfully");

        }

    public static void deleteClient(Context context){
        Integer clientId = Integer.parseInt(context.pathParam("id"));

        clientsService.deleteClient(clientId);

        List<Clients> checkClients = new ArrayList<>();
        checkClients.add(new Clients(1, "alennox@dreamville.com", "Ari", "Lennox"));
        checkClients.add(new Clients(2, "cbailey24@yahoo.com", "Champ", "Bailey"));
        checkClients.add(new Clients(3, "dnowitzki@dallasmavs.net", "Dirk", "Nowitzki"));
        checkClients.add(new Clients(4, "emusk@spacex.com", "Elon", "Musk"));
        checkClients.add(new Clients(5, "jbrown@soulmail.com", "James", "Brown"));
        checkClients.add(new Clients(6, "jcole@dreamville.com", "Jermaine", "Cole"));
        checkClients.add(new Clients(7, "ljames@lalakers.com", "Lebron", "James"));
        checkClients.add(new Clients(8, "lrichie@outlook.com", "Lionel", "Richie"));
        checkClients.add(new Clients(9, "mjackson@astromail.com", "Michael", "Jackson"));
        checkClients.add(new Clients(10, "mjordan@spacemail.net", "Michael", "Jordan"));
        checkClients.add(new Clients(11, "nosaka@olympics.com", "Naomi", "Osaka"));
        checkClients.add(new Clients(12, "obrown@thatsoraven.net", "Orlando", "Brown"));
        checkClients.add(new Clients(13, "pgeorge@clippers.com", "Paul", "George"));
        checkClients.add(new Clients(14, "qelizabeth@england.eng", "Queen", "Elizabeth"));
        checkClients.add(new Clients(15, "rmoss@patriots.com", "Randy", "Moss"));

        if (clientsService.getAllClients() != checkClients){
            context.status(205).result("Deleted client with id " + clientId);

        }else {
            context.status(404).result("No such client exists");
        }
    }
 }


