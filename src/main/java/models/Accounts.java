package models;

import java.sql.Time;

public class Accounts {
    private Integer account_no;
    private Integer client_id;
    private String client_username;
    private String client_firstname;
    private String client_lastname;
    private Double account_balance;
    private Double account_withdraw;

    public Accounts(){

    }

    public Accounts(Integer account_no, Integer client_id, String client_username, String client_firstname,
                    String client_lastname, Double account_balance){
        this.account_no = account_no;
        this.client_id = client_id;
        this.client_username = client_username;
        this.client_firstname = client_firstname;
        this.client_lastname = client_lastname;
        this.account_balance = account_balance;
        this.account_withdraw = account_withdraw;
    }

    public Integer getAccount_no() {return account_no;}

    public void setAccount_no(Integer account_no) {this.account_no = account_no;}

    public Integer getClient_id() {return client_id;}

    public void setClient_id(Integer client_id) {this.client_id = client_id;}

    public String getClient_username() {return client_username;}

    public void setClient_username(String client_username) {this.client_username = client_username;}

    public String getClient_firstname() {return client_firstname;}

    public void setClient_firstname(String client_firstname) {this.client_firstname = client_firstname;}

    public String getClient_lastname() {return client_lastname;}

    public void setClient_lastname(String client_lastname) {this.client_lastname = client_lastname;}


    public Double getAccount_balance() {return account_balance;}

    public void setAccount_balance(Double account_balance) {this.account_balance = account_balance;}

    public Double getAccount_withdraw() {return account_withdraw;}

    public void setAccount_withdraw(Double account_withdraw) {this.account_withdraw = account_withdraw;}

    @Override
    public String toString() {
        return "Accounts{" +
                "account_no=" + account_no +
                ", client_id=" + client_id +
                ", client_username='" + client_username + '\'' +
                ", client_firstname='" + client_firstname + '\'' +
                ", client_lastname='" + client_lastname + '\'' +
                ", account_balance=" + account_balance +
                ", account_withdraw=" + account_withdraw +
                '}';
    }
}

