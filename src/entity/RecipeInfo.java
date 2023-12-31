package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class RecipeInfo implements Serializable {

    private int recipeID;
    private int servings;
    private int readyInMinutes;
    private int healthScore;
    private Collection<String> ingredients;
    private Collection<String> instructions;
    private final boolean isUserCreatedRecipe;
    private static int userCreatedRecipeID = -1;

    public RecipeInfo(int recipeID, int servings, int readyInMinutes, int healthScore, Collection<String> ingredients, Collection<String> instructions) {
        this.recipeID = recipeID;
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.healthScore = healthScore;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.isUserCreatedRecipe = false;
    }


    public RecipeInfo(int servings, int readyInMinutes,
                      Collection<String> ingredients, Collection<String> instructions) {
        this.recipeID = userCreatedRecipeID;
        userCreatedRecipeID--;
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.healthScore = -1;
        this.isUserCreatedRecipe = true;}

    public boolean isUserCreatedRecipe() {
        return isUserCreatedRecipe;}

    public static int getUserCreatedRecipeID() {
        return userCreatedRecipeID;
    }
    public int getRecipeID() {
        return recipeID;
    }

    public int getServings() {
        return servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public Collection<String> getIngredients() {
        return ingredients;
    }

    public Collection<String> getInstructions() {
        return instructions;
    }

    public  String ingredientsToString() {
        String ingredientString = "";
        Integer i = 1;
        for (String item : ingredients) {
            ingredientString += "- " + item.substring(0, 1).toUpperCase() + item.substring(1) +"\n";
            i++;
        }
        return ingredientString;
    }


    @Override
    public String toString() {
        if (!this.isUserCreatedRecipe) {
            return "Servings:"+ servings + "\n" + "ReadyInMinutes:" + readyInMinutes + "\n" + "HealthScore:" + healthScore
                    + "\n" + "Ingredients:" + "\n" + ingredientsToString() + "\n" + "Instructions:" + instructionsToString();
        } else {
            return "Servings:"+ servings + "\n" + "ReadyInMinutes:" + readyInMinutes + "\n" + "Ingredients:"
                    + "\n" + ingredientsToString() + "\n" + "Instructions:" + instructionsToString();
        }
    }

    public String instructionsToString(){
        String instructionsString = "\n";
        for (int i = 0; i < instructions.size(); i++) {
            instructionsString += i + 1 + ": " + new ArrayList<>(instructions).get(i) + "\n";
        }
        return instructionsString;
    }
}
