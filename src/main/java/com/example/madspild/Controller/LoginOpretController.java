package com.example.madspild.Controller;

import com.example.madspild.Model.CompanyUser;
import com.example.madspild.Service.CompanyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/opretLogin")
public class LoginOpretController {

    @Autowired
    CompanyUserService companyUserService; // Service layer til håndtering af brugerdata

    // Viser login siden
    @GetMapping("/login")
    public String showLogin() {
        return "login"; // Returnerer login.html Thymeleaf template
    }

    // Behandler login forsøg
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        // Finder bruger baseret på email og password
        CompanyUser user = companyUserService.findCompanyUserByEmailAndPassword(email, password);
        if(user != null) {
            // Succesfuldt login - omdiriger til brugerens side
            return "redirect:/minSide";
        } else {
            // Fejl ved login - vis fejlmeddelelse
            model.addAttribute("error", "Forkert email eller Password");
            return "login"; // Bliver på login siden med fejlmeddelelse
        }
    }

    // Viser brugeroprettelsesformularen
    @GetMapping("/opretBruger")
    public String showLoginForm(Model model) {
        // Tilføjer et nyt CompanyUser objekt til formularen
        model.addAttribute("companyUser", new CompanyUser());
        return "opretBruger"; // Returnerer opretBruger.html Thymeleaf template
    }

    // Behandler brugeroprettelse
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

        // Tjek om cvr nummer er 8 cifre
        if(String.valueOf(companyUser.getCvr()).length() != 8) {
            model.addAttribute("error", "CVR ikke gyldigt");
            return "opretBruger";
        }

        // Alt validering er ok, opret bruger
        companyUserService.addCompanyUser(companyUser);

        // Omdiriger til login siden efter succesfuld oprettelse
        return "redirect:/opretLogin/login";
    }

}
