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

    private String fruitId;
    private String fruitName;
    private String taste;
    private String location;

    public Fruit(){

    }

    public Fruit(String fruitId, String fruitName, String taste, String location) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.taste = taste;
        this.location = location;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> fruit = new HashMap<>();
        fruit.put("fruitId",fruitId);
        fruit.put("fruitname",fruitName);
        fruit.put("taste",taste);
        fruit.put("location",location);

        return fruit;
    }
}
