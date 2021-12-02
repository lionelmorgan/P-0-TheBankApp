package frontcontroller;
import controllers.AccountsController;
import controllers.ClientsController;
import io.javalin.Javalin;

public class Dispatcher {

    public Dispatcher(Javalin app) {

        app.get("/clients", ClientsController::getAllClients);
        app.get("/clients/{id}", ClientsController::getOneClient);
        app.post("/clients", ClientsController::createClient);
        app.put("/clients/{id}", ClientsController::updateClient);
        app.delete("/clients/{id}", ClientsController::deleteClient);
        app.get("/accounts", AccountsController::getAllAccounts);
        app.get("/accounts/{id}", AccountsController::getAccount);
        app.get("/accounts/accountExact/{id}", AccountsController::getAccountExact);
        app.get("/accounts/accountRange/{id}", AccountsController::getAccountRange);
        app.post("/accounts/{id}", AccountsController::createAccount);
        app.put("/accounts/{id}", AccountsController::updateAccount);
        app.delete("/accounts/{id}", AccountsController::deleteAccount);
        app.patch("/accounts/{id}", AccountsController::withdrawFomAccount);

    }
}