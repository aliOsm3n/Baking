package com.example.aliothman.baking.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ali Othman on 20/06/2017.
 */

public class Ingredients {

    private double quantity;
    private String measure;
    private String ingredient;

    public  Ingredients(JSONObject Ingredients_json ){
         try {
             this.quantity = Ingredients_json.getDouble("quantity");
             this.measure = Ingredients_json.getString("measure");
             this.ingredient = Ingredients_json.getString("ingredient");
         }catch (JSONException e){
             e.printStackTrace();
         }
    }

    public double getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }
}
