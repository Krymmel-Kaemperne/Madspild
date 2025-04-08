package com.example.madspild.Controller;

import com.example.madspild.Model.Ingredient;
import com.example.madspild.Model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class KoleskaberenController {
//hashmap til at så man kan søge på som opbevarer et objekt af recipe, baseret på recipeID
    private final Map<Integer, Recipe> recipes = new HashMap<>();


    public KoleskaberenController() {

        Ingredient egg = new Ingredient(1, "æg");
        Ingredient potato = new Ingredient(1, "kartoffel");
        //vis opskrifter
        recipes.put(1, new Recipe(egg, 1, "Pocherede Æg", "1. Kog vandet op i en gryde og tilsæt eddike.\n" +
                "2. Slå æggene ud i små skåle.\n" + "3. Lav en hvirvel i vandet med en ske og hæld forsigtigt æggene i.\n" +
                "4. Pocher æggene i 3-4 minutter, indtil hviden er fast.\n" + "5. Tag æggene op med en hulske og server.", "/img/recipe/poached-egg.jpg"));
        recipes.put(2, new Recipe(egg, 2, "Æggekage",
                "1. Pisk æggene sammen med mælk og lidt salt.\n2. Steg bacon sprødt på en pande.\n" +
                        "3. Hæld æggeblandingen over baconen og steg ved lav varme.\n4. " +
                        "Når æggekagen er fast, pynt med purløg og server.", "/img/recipe/egg-cake.jpg"));
        recipes.put(3, new Recipe(egg, 3, "Arme Riddere",
                "1. Pisk æg, mælk og kanel sammen i en skål.\n2. Dyp brødskiverne i blandingen.\n" +
                        "3. Steg brødet i smør på en pande, indtil det er gyldent.\n4. Server med sukker eller syltetøj.", "/img/recipe/arme-riddere.jpg"));
        recipes.put(4, new Recipe(egg, 4, "Blødkogte Æg",
                "1. Kog vandet op i en gryde.\n2. Læg æggene forsigtigt i det kogende vand.\n" +
                        "3. Kog æggene i 5-6 minutter for blødkogte æg.\n" +
                        "4. Tag æggene op og server med salt og brød.", "/img/recipe/boiled-egg.jpg"));
        recipes.put(5, new Recipe(egg, 5, "Spejlæg",
                "1. Varm en pande op med lidt smør eller olie.\n2. Slå ægget ud på panden.\n" +
                        "3. Steg ægget i 2-3 minutter, indtil hviden er fast, men blommen stadig er blød.\n" +
                        "4. Krydr med salt og peber og server.", "/img/recipe/friedegg.jpg"));
        recipes.put(6, new Recipe(egg, 6, "Omelet",
                "1. Pisk æggene sammen med lidt mælk, salt og peber.\n2. Varm en pande op med lidt smør.\n" +
                        "3. Hæld æggeblandingen på panden og steg ved lav varme.\n" +
                        "4. Fold omeletten sammen, når den er fast, og server.", "/img/recipe/omelet.jpg"));

        recipes.put(7, new Recipe(potato, 7, "Bagt Kartoffel",
                "1. Forvarm ovnen til 200°C.\n" +
                        "2. Vask kartoflerne og prik dem med en gaffel.\n" +
                        "3. Gnid kartoflerne med olivenolie, salt og peber.\n" +
                        "4. Bag i 50-60 minutter, indtil skindet er sprødt og indersiden er blød.\n" +
                        "5. Server med smør, creme fraiche eller dine yndlings toppings.",
                "/img/recipe/baked-potato.jpg"));
        recipes.put(8, new Recipe(potato, 8, "Kartoffelmos",
                "1. Skræl og skær kartoflerne i mindre stykker.\n" +
                        "2. Kog kartoflerne i saltet vand i 15-20 minutter, indtil de er møre.\n" +
                        "3. Hæld vandet fra og mos kartoflerne.\n" +
                        "4. Tilsæt mælk, smør og salt, og rør indtil det er glat.\n" +
                        "5. Server som tilbehør.",
                "/img/recipe/mashed-potatoes.jpg"));
        recipes.put(9, new Recipe(potato, 9, "Kartoffelbåde",
                "1. Forvarm ovnen til 200°C.\n" +
                        "2. Vask kartoflerne og skær dem i både.\n" +
                        "3. Vend bådene i olivenolie, paprika, hvidløgspulver, salt og peber.\n" +
                        "4. Fordel bådene på en bageplade og bag i 30-40 minutter, vend halvvejs.\n" +
                        "5. Server med ketchup eller din yndlingsdip.",
                "/img/recipe/potato-wedges.jpg"));
        recipes.put(10, new Recipe(potato, 10, "Kartoffelsalat",
                "1. Kog kartoflerne i saltet vand, indtil de er møre, og lad dem køle af.\n" +
                        "2. Skræl og skær kartoflerne i mundrette stykker.\n" +
                        "3. Bland mayonnaise, sennep, hakket rødløg, persille, salt og peber i en skål.\n" +
                        "4. Tilsæt kartoflerne og rør, indtil de er godt dækket.\n" +
                        "5. Stil på køl i 1 time før servering.",
                "/img/recipe/potato-salad.jpg"));
        recipes.put(11, new Recipe(potato, 11, "Flødekartofler",
                "1. Forvarm ovnen til 180°C.\n" +
                        "2. Skræl og skær kartoflerne i tynde skiver.\n" +
                        "3. Læg kartoflerne lagvis i et ovnfast fad med hvidløg, fløde og ost.\n" +
                        "4. Krydr hvert lag med salt og peber.\n" +
                        "5. Bag i 45-50 minutter, indtil toppen er gylden og kartoflerne er møre.\n" +
                        "6. Server som tilbehør eller hovedret.",
                "/img/recipe/potato-gratin.jpg"));

        recipes.put(12, new Recipe(potato, 12, "Hasselback Kartofler",
                "1. Forvarm ovnen til 200°C.\n" +
                        "2. Vask kartoflerne og skær dem i tynde skiver, men ikke helt igennem.\n" +
                        "3. Pensl kartoflerne med smeltet smør og drys med salt og peber.\n" +
                        "4. Bag kartoflerne i ovnen i 40-50 minutter, pensl med smør undervejs.\n" +
                        "5. Server som tilbehør eller snack.",
                "/img/recipe/hasselback-potatoes.jpg"));

    }

    @GetMapping("/koleskaberen")
    public String koleskaberen(
            //kigger på url efter en af følgende parametre
            @RequestParam(value = "ingredient", required = false) String ingredient,
            @RequestParam(value = "recipeID", required = false) Integer recipeID,
            Model model) {
        //hvis den finder et recipeID i url, tilføjes disse parametre til modellen, så thymeleaf kan vise opskriften
        if (recipeID != null && recipes.containsKey(recipeID)) {
            Recipe selectedRecipe = recipes.get(recipeID);
            model.addAttribute("showRecipeDetails", true);
            model.addAttribute("recipeName", selectedRecipe.getRecipeName());
            model.addAttribute("recipeInstructions", selectedRecipe.getRecipeInstructions());
            model.addAttribute("recipeImage", selectedRecipe.getImagePath());
        } else if (ingredient == null || ingredient.isEmpty()) {
            // hvis der hverken er recipeid eller ingrediens viser den køleskab.
            model.addAttribute("showFridgeImage", true);
            model.addAttribute("recipes", Collections.emptyList());
        } else {
            // Viser ingredienser baseret på hovedingrediensen.
            List<Recipe> filteredRecipes = recipes.values().stream()
                    .filter(recipe -> recipe.getIngredient().getIngredientName().equalsIgnoreCase(ingredient))
                    .collect(Collectors.toList());
            model.addAttribute("showFridgeImage", false);
            model.addAttribute("recipes", filteredRecipes);
        }
        model.addAttribute("ingredient", ingredient); // Always pass the ingredient to Thymeleaf
        return "koleskaberen";
    }
}