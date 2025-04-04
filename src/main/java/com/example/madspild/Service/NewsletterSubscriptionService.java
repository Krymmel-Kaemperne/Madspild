package com.example.madspild.Service;

import com.example.madspild.Model.FoodListing;
import com.example.madspild.Model.NewsletterSubscription;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsletterSubscriptionService {

    //OPRET EN AUTOWIRE TIL REPO
    private final JavaMailSender mailSender;
    private final static List<NewsletterSubscription> subscriptions = new ArrayList<>();

    public NewsletterSubscriptionService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public List<NewsletterSubscription> getAllNewsletterSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    public void addNewsletterSubscription(NewsletterSubscription subscription, RedirectAttributes redirectAttributes) {
        subscriptions.add(subscription);
        sendWelcomeEmail(subscription.getEmail(), redirectAttributes);
    }

    private void sendWelcomeEmail(String email, RedirectAttributes redirectAttributes) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("madspild.nyhedsbrev@gmail.com");
            message.setTo(email);
            message.setSubject("Velkommen til vores nyhedsbrev");
            message.setText(
                    "Kære Bruger, \n\n" +
                    "Tak for din tilmelding til Madspild nyhedsbrevet. \n\n" +
                    "Du vil løbende modtage tips og tricks til at reducere madspild.\n\n" +
                    "Med venlig hilsen, \n" +
                    "Operation Madspild"
            );

            mailSender.send(message);
            redirectAttributes.addFlashAttribute("sentEmail ", email);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("Email error", "Kunne ikke sende bekræftelsesmail til " + email);
        }
    }



    public NewsletterSubscription findNewsletterSubscriptionById(int id) {
        return null;
    }

    public void deleteNewsletterSubscription(int id) {
    }

    public void updateNewsletterSubscription(NewsletterSubscription ns) {
    }

}
