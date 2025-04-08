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
    CompanyUserService companyUserService;

    //CompanyUser currentUser;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        CompanyUser user = companyUserService.findCompanyUserByEmailAndPassword(email, password);
        if(user != null) {
            return "redirect:/minSide";
        } else {
            model.addAttribute("error", "Forkert email eller Password");
            return "login";
        }
    }

    @GetMapping("/opretBruger")
    public String showLoginForm(Model model) {
        model.addAttribute("companyUser", new CompanyUser());
        return "opretBruger";
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

        if(String.valueOf(companyUser.getCvr()).length() != 8) {
            model.addAttribute("error", "CVR ikke gyldigt");
            return "opretBruger";
        }

        companyUserService.addCompanyUser(companyUser);
        return "redirect:/opretLogin/login";
    }

}
