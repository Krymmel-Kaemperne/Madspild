package com.example.madspild.Model;

public class CompanyUser {

    private int companyId;
    private String name;
    private String address;
    private String industry;
    private String contactPerson;
    private String email;
    private int cvr;
    private String password;

    public CompanyUser() {
    }

    public CompanyUser(int companyId, String name, String address,
                       String industry, String contactPerson, String email, int cvr, String password) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.industry = industry;
        this.contactPerson = contactPerson;
        this.email = email;
        this.cvr = cvr;
        this.password = password;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
