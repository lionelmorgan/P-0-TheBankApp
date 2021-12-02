package models;

public class Clients {
    private Integer client_id;
    private String client_username;
    private String client_firstname;
    private String client_lastname;


    public Clients() {

    }

    public Clients(Integer client_id, String client_username, String client_firstname, String client_lastname){
        this.client_id = client_id;
        this.client_username = client_username;
        this.client_firstname = client_firstname;
        this.client_lastname = client_lastname;
    }

    public Integer getClient_id() {return client_id;}

    public void setClient_id(Integer client_id) {this.client_id = client_id;}

    public String getClient_username() {return client_username;}

    public void setClient_username(String client_username) {this.client_username = client_username;}

    public String getClient_firstname() {return client_firstname;}

    public void setClient_firstname(String client_firstname) {this.client_firstname = client_firstname;}

    public String getClient_lastname() {return client_lastname;}

    public void setClient_lastname(String client_lastname) {this.client_lastname = client_lastname;}

    @Override
    public String toString() {
        return "Clients{" +
                "client_id=" + client_id +
                ", client_username='" + client_username + '\'' +
                ", client_firstname='" + client_firstname + '\'' +
                ", client_lastname='" + client_lastname + '\'' +
                '}';
    }
}