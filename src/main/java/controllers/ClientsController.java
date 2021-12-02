package controllers;

import dao.ClientsDaoImpl;
import io.javalin.http.Context;
import models.Clients;
import services.ClientsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ClientsController {

    static ClientsService clientsService = new ClientsService(new ClientsDaoImpl());

    public static void getAllClients(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        List<Clients> clientsList = clientsService.getAllClients();
        String jsonString = new ObjectMapper().writeValueAsString(clientsList);
        context.result(jsonString);

    }

    public static void getOneClient(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        Integer clientId = Integer.parseInt(context.pathParam("id"));
        Clients client = ClientsService.getOneClient(clientId);
        context.result(new ObjectMapper().writeValueAsString(client));
    }

    public static void createClient(Context context) {
        Clients client = context.bodyAsClass(Clients.class);
        if (clientsService.createClient(client)) {
            context.result("Client created");

        } else {
            context.result("Client creation is more than 50 characters");
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

        context.result("Deleted client with id " + clientId);
    }
 }


