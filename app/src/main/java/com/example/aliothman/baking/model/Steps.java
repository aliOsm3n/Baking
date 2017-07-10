package com.example.aliothman.baking.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ali Othman on 20/06/2017.
 */

public class Steps {


    private int id ;
    private String shortDescription;
    private String description;
    private String videoURL;
    private String thumbnailURL;


    public  Steps(JSONObject Steps_Json){
        try {
            this.id = Steps_Json.getInt("id");
            this.shortDescription = Steps_Json.getString("shortDescription");
            this.description = Steps_Json.getString("description");
            this.videoURL = Steps_Json.getString("videoURL");
            this.thumbnailURL = Steps_Json.getString("thumbnailURL");
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }
}
