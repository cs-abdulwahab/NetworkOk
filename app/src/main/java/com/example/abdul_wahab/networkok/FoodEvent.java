package com.example.abdul_wahab.networkok;

import com.example.abdul_wahab.networkok.models.Food;

import java.util.List;

/**
 * Created by Abdul-Wahab on 10/22/2017.
 */

class FoodEvent {

    private List<Food> foodList;

    public FoodEvent(List<Food> foods) {

        foodList = foods;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
