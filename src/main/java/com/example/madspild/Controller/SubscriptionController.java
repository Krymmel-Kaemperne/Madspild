package com.example.madspild.Controller;

import com.example.madspild.Model.NewsletterSubscription;
import com.example.madspild.Service.NewsletterSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class SubscriptionController {

    // Injecter service der håndterer nyhedsbrevstilmeldinger
    @Autowired
    NewsletterSubscriptionService newsletterSubscriptionService;

    // Håndterer formularindsendelse til nyhedsbrevstilmelding
    @PostMapping("/tilmeld-nyhedsbrev")
    public String submitSubscription(NewsletterSubscription subscription, RedirectAttributes redirectAttributes) {
        // Validering: Tjek om e-mail er udfyldt
        if(subscription.getEmail() == null || subscription.getEmail().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Email er påkrævet");
            return "redirect:/#footer"; // Returnerer kun formulardelen
        }
        // Validering: Tjek om brugeren har accepteret betingelser
        if(!subscription.isAcceptTerms()) {
            redirectAttributes.addFlashAttribute("error", "Du skal acceptere betingelserne");
            return "redirect:/#footer";
        }

        // Gemmer tilmeldingen og sender velkomstmail
        newsletterSubscriptionService.addNewsletterSubscription(subscription, redirectAttributes);
        // Logger e-mail til konsollen (til debugging)
        System.out.println("Ny tilmelding " + subscription.getEmail()); // Log til console

        // Omdiriger til "tak for tilmelding" side
        return "redirect:/tak-for-tilmelding";
    }

    // Viser takkeside efter succesfuld tilmelding
    @GetMapping("/tak-for-tilmelding")
    public String thankYouPage(@ModelAttribute("sentEmail") String email, Model model) {
        model.addAttribute("email", email);
        return "tak-for-tilmelding"; // Returnerer tak-for-tilmelding.html
    }
}
