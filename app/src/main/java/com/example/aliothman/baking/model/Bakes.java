package com.example.aliothman.baking.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ali Othman on 20/06/2017.
 */

public class Bakes {

    private  String name;
    private ArrayList<Ingredients> ingredients;
    private ArrayList<Steps> steps;
    private String servings;
    private String image;

    public Bakes(JSONObject bakes_json){
        try {
            this.name = bakes_json.getString("name");

            this.ingredients = new ArrayList<>();
            JSONArray IngredientsJA = bakes_json.getJSONArray("ingredients");
            for (int i = 0; i < IngredientsJA.length(); i++) {
                ingredients.add(new Ingredients(IngredientsJA.getJSONObject(i)));
            }

            this.steps = new ArrayList<>();
            JSONArray StepsJA = bakes_json.getJSONArray("steps");
            for (int i = 0; i < StepsJA.length(); i++) {
                steps.add(new Steps(StepsJA.getJSONObject(i)));
            }

            this.servings = bakes_json.getString("servings");

            this.image = bakes_json.getString("image");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public ArrayList<Steps> getSteps() {
        return steps;
    }

    public String getServings() {
        return servings;
    }

    public String getImage() {
        return image;
    }
}
