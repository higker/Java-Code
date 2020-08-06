package com.dicitek.cms.model;

public class sysInfo {
    private Integer id;
    private String company;
    private String address;
    private String telephone;
    private String fax;

    @Override
    public String toString() {
        return "sysInfo{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }

    public sysInfo() {
    }

    public sysInfo(String company, String address, String telephone, String fax) {
        this.company = company;
        this.address = address;
        this.telephone = telephone;
        this.fax = fax;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
