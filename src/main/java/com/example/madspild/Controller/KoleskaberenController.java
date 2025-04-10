package com.example.madspild.Controller;

import com.example.madspild.Model.Recipe;
import com.example.madspild.Service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class KoleskaberenController {

    private final RecipeService recipeService;

    public KoleskaberenController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/koleskaberen")
    public String koleskaberen(
            @RequestParam(value = "ingredient", required = false) String ingredient, // Ingrediens fra brugerens input
            @RequestParam(value = "recipeID", required = false) Integer recipeID,   // ID for en specifik opskrift
            Model model) {

        // Hvis recipeID er angivet, vis detaljer for den specifikke opskrift
        if (recipeID != null) {
            Recipe selectedRecipe = recipeService.findRecipeById(recipeID); // Hent opskriften baseret på ID
            if (selectedRecipe != null) {
                model.addAttribute("showRecipeDetails", true); // Vis opskriftsdetaljer
                model.addAttribute("recipeName", selectedRecipe.getRecipeName());
                model.addAttribute("recipeInstructions", selectedRecipe.getRecipeInstructions());
                model.addAttribute("recipeImage", selectedRecipe.getImagePath());
                model.addAttribute("recipes", Collections.emptyList());
                return "koleskaberen"; //
            }
        }

        // Hvis ingen ingrediens er angivet, vis køleskabsbilledet
        if (ingredient == null || ingredient.isEmpty()) {
            model.addAttribute("showFridgeImage", true); // Vis køleskabsbilledet
            model.addAttribute("recipes", Collections.emptyList()); // Ingen opskrifter vises
            model.addAttribute("showRecipeDetails", false); // Skjul opskriftsdetaljer
            return "koleskaberen"; // Returner skabelonen
        }

        // Hvis en ingrediens er angivet, filtrer opskrifter baseret på ingrediensen
        List<Recipe> filteredRecipes = recipeService.findRecipesByIngredient(ingredient); // Hent opskrifter baseret på ingrediens
        model.addAttribute("showFridgeImage", false); // Skjul køleskabsbilledet
        model.addAttribute("showRecipeDetails", false); // Skjul opskriftsdetaljer
        model.addAttribute("recipes", filteredRecipes);

        // Hvis der ikke findes opskrifter, vis en fejlbesked
        if (filteredRecipes.isEmpty()) {
            model.addAttribute("noRecipesMessage", "Der er ingen opskrifter oprettet for ingrediensen " + ingredient + ". Prøv igen.");
        }


        model.addAttribute("ingredient", ingredient);
        return "koleskaberen";
    }
}
