package me.ibyte.book.mall.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 图书实体类
 */
public class Book {

    private Long Id;
    private String Author;
    private BigDecimal Money;
    private String Introduction;
    private String PicUrl;
    private Timestamp createTime;
    private int Number;
    private String BookName;

    public Book(String author, BigDecimal money, String introduction, String picUrl, Timestamp createTime, int number, String bookName) {
        Author = author;
        Money = money;
        Introduction = introduction;
        PicUrl = picUrl;
        this.createTime = createTime;
        Number = number;
        BookName = bookName;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public Book() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public BigDecimal getMoney() {
        return Money;
    }

    public void setMoney(BigDecimal money) {
        Money = money;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
