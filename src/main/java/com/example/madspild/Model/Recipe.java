package com.example.madspild.Model;

public class Recipe {

    private Ingredient ingredient;
    private int recipeID;
    private String recipeName;
    private String recipeInstructions;
    private String imagePath;

    public Recipe() {
    }

    public Recipe(Ingredient ingredient, int recipeID, String recipeName, String recipeInstructions, String imagePath) {
        this.ingredient = ingredient;
        this.recipeID = recipeID;
        this.recipeName = recipeName;
        this.recipeInstructions = recipeInstructions;
        this.imagePath = imagePath;

    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

}
