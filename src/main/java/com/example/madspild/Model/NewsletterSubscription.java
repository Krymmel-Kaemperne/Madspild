package com.example.madspild.Model;

import java.time.LocalDate;

public class NewsletterSubscription {


    private String email;
    private boolean acceptTerms;

    public NewsletterSubscription() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }
}
