package com.example.madspild.Model;

import java.time.LocalDate;

public class FoodListing {

    private int foodListingId;
    private CompanyUser companyUser;
    private String listingText;
    private LocalDate expirationDate;

    public FoodListing() {
    }

    public FoodListing(int foodListingId, CompanyUser companyUser,
                       String listingText, LocalDate expirationDate) {
        this.foodListingId = foodListingId;
        this.companyUser = companyUser;
        this.listingText = listingText;
        this.expirationDate = expirationDate;
    }

    public int getFoodListingId() {
        return foodListingId;
    }

    public void setFoodListingId(int foodListingId) {
        this.foodListingId = foodListingId;
    }

    public CompanyUser getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(CompanyUser companyUser) {
        this.companyUser = companyUser;
    }

    public String getListingText() {
        return listingText;
    }

    public void setListingText(String listingText) {
        this.listingText = listingText;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
