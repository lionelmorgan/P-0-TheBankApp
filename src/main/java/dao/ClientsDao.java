package dao;/* Data Access Object (DAO) Design Pattern: Define an interface which declares methods through which the database will be queried.
 *  - Create, Read, Update, Delete (CRUD) Operations
*/

import models.Clients;

import java.util.List;

public interface ClientsDao {
    List<Clients> getAllClients();
    Clients getOneClient(Integer clientId);
    Boolean createClient(Clients client);
    void updateClient(int clientId);
    void deleteClient(Integer clientId);
}
