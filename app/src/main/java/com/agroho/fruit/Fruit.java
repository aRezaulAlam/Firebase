package com.agroho.fruit;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by USER on 8/26/2016.
 */
@IgnoreExtraProperties
public class Fruit {

    private Long fruitId;
    private String fruitName;
    private String fruitSummary;
    private String fruitDetails;

    public Fruit(){

    }

    public Fruit(Long fruitId, String fruitName, String fruitSummary, String fruitDetails) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitSummary = fruitSummary;
        this.fruitDetails = fruitDetails;
    }

    public Fruit(String fruitName, String fruitSummary) {
        this.fruitName = fruitName;
        this.fruitSummary = fruitSummary;
    }

    public Long getFruitId() {
        return fruitId;
    }

    public void setFruitId(Long fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitSummary() {
        return fruitSummary;
    }

    public void setFruitSummary(String fruitSummary) {
        this.fruitSummary = fruitSummary;
    }

    public String getFruitDetails() {
        return fruitDetails;
    }

    public void setFruitDetails(String fruitDetails) {
        this.fruitDetails = fruitDetails;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> fruits = new HashMap<>();
        fruits.put("fruitID", 1);
        fruits.put("fruitName", fruitName);
        fruits.put("fruitSummary", fruitSummary);
        fruits.put("fruitDetails", "fruitDetails");


        return fruits;
    }
}
