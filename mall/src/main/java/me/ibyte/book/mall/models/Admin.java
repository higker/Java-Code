package me.ibyte.book.mall.models;


public class Admin {
    private int Id;
    private String Account;
    private String Password;

    public Admin(String account, String password) {
        Account = account;
        this.Password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Id=" + Id +
                ", Account='" + Account + '\'' +
                ", password='" + Password + '\'' +
                '}';
    }

    public Admin() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
