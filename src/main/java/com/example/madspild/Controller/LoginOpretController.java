package com.example.madspild.Controller;

import com.example.madspild.Model.CompanyUser;
import com.example.madspild.Service.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginOpretController {

    @Autowired
    CompanyUserService companyUserService;

    CompanyUser currentUser;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        CompanyUser user = companyUserService.findCompanyUserByEmailAndPassword(email, password);
        if(user != null) {
            return "redirect:/minSide";
        } else {
            model.addAttribute("error", "Forkert email eller CVR");
            return "login";
        }
    }

    @PostMapping("/opretBruger")
    public String opretBruger (@ModelAttribute CompanyUser companyUser,
                               @RequestParam String confirmPassword, Model model) {

        //Validér at password matcher
        if(!companyUser.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Adgangskode matcher ikke");
            return "opretBruger";
        }

        // Tjek om email allerede eksisterer
        if(companyUserService.findCompanyUserByEmail(companyUser.getEmail()) != null) {
            model.addAttribute("error", "Email er allerede i brug");
            return "opretBruger";
        }

        companyUserService.addCompanyUser(companyUser);
        currentUser = companyUser;
        return "redirect:/minSide";
    }

}
