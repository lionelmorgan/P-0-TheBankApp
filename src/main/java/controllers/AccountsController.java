package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountsDaoImpl;
import dao.ClientsDaoImpl;
import io.javalin.http.Context;
import models.Accounts;
import models.Clients;
import services.AccountsService;
import services.ClientsService;

import java.util.List;

public class AccountsController {

    static AccountsService accountsService = new AccountsService(new AccountsDaoImpl());

    public static void getAllAccounts(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        List<Accounts> accountsList = accountsService.getAllAccounts();
        String jsonString = new ObjectMapper().writeValueAsString(accountsList);
        context.result(jsonString);

    }

    public static void createAccount(Context context) {
        Accounts account = context.bodyAsClass(Accounts.class);
        if (accountsService.createAccount(account)) {
            context.result("Account created");

        } else {
            context.result("Account creation is more than 50 characters");
        }

    }

    public static void getAccount(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        Integer clientId = Integer.parseInt(context.pathParam("id"));
        List<Accounts> client = accountsService.getAccount(clientId);
        context.result(new ObjectMapper().writeValueAsString(client));
    }
    public static void getAccountExact(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        Integer clientId = Integer.parseInt(context.pathParam("id"));
        List<Accounts> client = accountsService.getAccountExact(clientId);
        if(client == null){
            context.status(404).result("Account does not exist");
        }else {
            context.result(new ObjectMapper().writeValueAsString(client));
        }
    }
    public static void getAccountRange(Context context) throws JsonProcessingException {
            context.contentType("application/json");
            Integer clientId = Integer.parseInt(context.pathParam("id"));
            List<Accounts> client = accountsService.getAccountRange(clientId);
            context.result(new ObjectMapper().writeValueAsString(client));
        }
    public static void updateAccount(Context context) {
        Accounts account = context.bodyAsClass(Accounts.class);
        Integer account_no = Integer.parseInt(context.pathParam("id"));
        accountsService.updateAccount(account);
        context.status(201).result("Account with id of " + account_no + " has been updated successfully");

    }

    public static void deleteAccount(Context context){
        Accounts account = context.bodyAsClass(Accounts.class);
        Integer account_no = Integer.parseInt(context.pathParam("id"));

        accountsService.deleteAccount(account);

        context.status(201).result("Deleted account with id" + account_no + " if it exists");
    }

    public static void withdrawFomAccount(Context context) {
        Accounts account = context.bodyAsClass(Accounts.class);
        Integer account_no = Integer.parseInt(context.pathParam("id"));
        accountsService.withdrawFromAccount(account);
        context.status(201).result("Account with id of " + account_no + " has been withdrawn successfully");

    }

    public static void transferToAccount(Context context) {
        Accounts account = context.bodyAsClass(Accounts.class);
        Integer account_no = Integer.parseInt(context.pathParam("id"));
        accountsService.transferToAccount(account);
        context.status(201).result("Account with id of " + account_no + " has had funds transfered to successfully");

    }
    }

