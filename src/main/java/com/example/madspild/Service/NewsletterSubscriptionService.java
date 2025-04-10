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

    // JavaMailSender bruges til at sende e-mails
    private final JavaMailSender mailSender;
    // Midlertidig liste til at gemme tilmeldinger (kan erstattes med database senere)
    private final static List<NewsletterSubscription> subscriptions = new ArrayList<>();

    // Constructor med dependency injection af JavaMailSender
    public NewsletterSubscriptionService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // Returnerer alle nyhedsbrevstilmeldinger
    public List<NewsletterSubscription> getAllNewsletterSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    // Tilføjer en ny tilmelding og sender en velkomstmail
    public void addNewsletterSubscription(NewsletterSubscription subscription, RedirectAttributes redirectAttributes) {
        subscriptions.add(subscription); // Tilføj til listen
        sendWelcomeEmail(subscription.getEmail(), redirectAttributes); // Send e-mail
    }

    // Sender en velkomstmail til den nye abonnent
    private void sendWelcomeEmail(String email, RedirectAttributes redirectAttributes) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("madspild.nyhedsbrev@gmail.com"); // Afsenderadresse
            message.setTo(email); // Modtagerens e-mail
            message.setSubject("Velkommen til vores nyhedsbrev"); // Emnefelt
            message.setText( // Brødtekst
                    "Kære Bruger, \n\n" +
                    "Tak for din tilmelding til Madspild nyhedsbrevet. \n\n" +
                    "Du vil løbende modtage tips og tricks til at reducere madspild.\n\n" +
                    "Med venlig hilsen, \n" +
                    "Danmark mod Madspild"
            );
            mailSender.send(message); // Forsøg at sende e-mailen
            redirectAttributes.addFlashAttribute("sentEmail", email); // Feedback til UI
        } catch (Exception e) {
            // Hvis der sker en fejl under afsendelse, tilføj fejlbesked til UI
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
