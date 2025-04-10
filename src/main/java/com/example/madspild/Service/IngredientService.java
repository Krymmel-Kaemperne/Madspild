package com.example.madspild.Service;

import com.example.madspild.Model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {

    // HashMap til at opbevare ingredienser, hvor nøglen er ingredientID, og værdien er et Ingredient-objekt
    private final Map<Integer, Ingredient> ingredients = new HashMap<>();

    // Konstruktor til at initialisere ingredienser
    public IngredientService() {
        ingredients.put(1, new Ingredient(1, "æg"));
        ingredients.put(2, new Ingredient(2, "kartoffel"));
        // Flere ingredienser kan tilføjes her...
    }

    // Hent alle ingredienser
    public Map<Integer, Ingredient> getAllIngredients() {
        return ingredients;
    }

    // Find en ingrediens baseret på ID
    public Ingredient findIngredientById(int id) {
        return ingredients.get(id);
    }
}
