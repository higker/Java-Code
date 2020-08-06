package com.dicitek.cms.model;


public class booking {

    private Integer id;
    private String phone;
    private String message;

    public String getPhone() {
        return phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public booking() {

    }

    public booking(String phone, String message) {
        this.phone = phone;
        this.message = message;
    }

    public booking(Integer id, String phone, String message) {
        this.id = id;
        this.phone = phone;
        this.message = message;
    }

    @Override
    public String toString() {
        return "booking{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
