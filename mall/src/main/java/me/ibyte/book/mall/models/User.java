package me.ibyte.book.mall.models;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class User {

    private Long Id;
    private String Email;
    private String Password;
    private Timestamp createTime;
    private BigDecimal Surplus;

    public BigDecimal getSurplus() {
        return Surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        Surplus = surplus;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", createTime=" + createTime +
                ", Surplus=" + Surplus +
                '}';
    }

    public User(String email, String password, Timestamp createTime, BigDecimal surplus) {
        Email = email;
        Password = password;
        this.createTime = createTime;
        Surplus = surplus;
    }

    public User(String email, String password, Timestamp createTime) {
        Email = email;
        Password = password;
        this.createTime = createTime;
    }

    public User() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
