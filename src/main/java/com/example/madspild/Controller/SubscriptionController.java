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

    @Autowired
    NewsletterSubscriptionService newsletterSubscriptionService;


    @PostMapping("/tilmeld-nyhedsbrev")
    public String submitSubscription(NewsletterSubscription subscription, RedirectAttributes redirectAttributes) {
        //Validering
        if(subscription.getEmail() == null || subscription.getEmail().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Email er påkrævet");
            return "redirect:/#footer"; // Returnerer kun formulardelen
        }
        if(!subscription.isAcceptTerms()) {
            redirectAttributes.addFlashAttribute("error", "Du skal acceptere betingelserne");
            return "redirect:/#footer";
        }

        // Gem email (I en liste)
        newsletterSubscriptionService.addNewsletterSubscription(subscription, redirectAttributes);
        System.out.println("Ny tilmelding " + subscription.getEmail()); // Log til console

        return "redirect:/tak-for-tilmelding";
    }

    @GetMapping("/tak-for-tilmelding")
    public String thankYouPage(@ModelAttribute("sentEmail") String email, Model model) {
        model.addAttribute("email", email);
        return "tak-for-tilmelding";
    }
}
