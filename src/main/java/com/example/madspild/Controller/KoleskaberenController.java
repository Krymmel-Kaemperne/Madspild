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
            @RequestParam(value = "ingredient", required = false) String ingredient,
            @RequestParam(value = "recipeID", required = false) Integer recipeID,
            Model model) {

        if (recipeID != null) {
            // Vis opskriftsdetaljer
            Recipe selectedRecipe = recipeService.findRecipeById(recipeID);
            if (selectedRecipe != null) {
                model.addAttribute("showRecipeDetails", true);
                model.addAttribute("recipeName", selectedRecipe.getRecipeName());
                model.addAttribute("recipeInstructions", selectedRecipe.getRecipeInstructions());
                model.addAttribute("recipeImage", selectedRecipe.getImagePath());
                model.addAttribute("showFridgeImage", false);
                model.addAttribute("recipes", Collections.emptyList());
            }
        } else if (ingredient == null || ingredient.isEmpty()) {
            // Vis køleskabsbilledet, hvis ingen ingrediens er angivet
            model.addAttribute("showFridgeImage", true);
            model.addAttribute("showRecipeDetails", false);
            model.addAttribute("recipes", Collections.emptyList());
        } else {
            // Filtrer opskrifter baseret på ingrediens
            List<Recipe> filteredRecipes = recipeService.findRecipesByIngredient(ingredient);
            model.addAttribute("showFridgeImage", false);
            model.addAttribute("showRecipeDetails", false);
            model.addAttribute("recipes", filteredRecipes);

            if (filteredRecipes.isEmpty()) {
                model.addAttribute("noRecipesMessage", "Der er ingen opskrifter oprettet for ingrediensen " + ingredient + ". Prøv igen.");
            }
        }

        model.addAttribute("ingredient", ingredient);
        return "koleskaberen";
    }
}
