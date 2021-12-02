package dao;//Now, implementation classes can implement the interface and contain the data access logic to return the required data.

import models.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDaoImpl implements ClientsDao {

    String url;
    String username;
    String password;

    public ClientsDaoImpl() {
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/capitaldatabase";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ClientsDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM clients;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clients.add(new Clients(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException a) {
            a.printStackTrace();
        }
        return clients;
    }

    @Override
    public Clients getOneClient(Integer clientId) {
        Clients client = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM clients WHERE client_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                client = new Clients(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }
            //conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void createClient(Clients client) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO clients VALUES (DEFAULT, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, client.getClient_username());
            ps.setString(2, client.getClient_firstname());
            ps.setString(3, client.getClient_lastname());
            ps.executeUpdate();

            //conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateClient(int clientId) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE clients SET client_username = 'obrown@disney.com' WHERE client_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ps.executeUpdate();

            //conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteClient(Integer clientId) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "DELETE FROM clients WHERE client_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ps.executeUpdate();
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
