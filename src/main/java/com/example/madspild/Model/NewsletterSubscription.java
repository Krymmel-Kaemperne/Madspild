package com.example.madspild.Model;

import java.time.LocalDate;

public class NewsletterSubscription {

    private int newsletterId;
    private String email;
    private LocalDate subscribeDate;

    public NewsletterSubscription() {
    }

    public NewsletterSubscription(int newsletterId, String email, LocalDate subscribeDate) {
        this.newsletterId = newsletterId;
        this.email = email;
        this.subscribeDate = subscribeDate;
    }

    public int getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(int newsletterId) {
        this.newsletterId = newsletterId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(LocalDate subscribeDate) {
        this.subscribeDate = subscribeDate;
    }
}
