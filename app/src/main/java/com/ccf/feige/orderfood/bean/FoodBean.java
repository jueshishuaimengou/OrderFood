package com.ccf.feige.orderfood.bean;

import java.io.Serializable;

public class FoodBean implements Serializable {

    @Override
    public String toString() {
        return "FoodBean{" +
                "foodId='" + foodId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodDes='" + foodDes + '\'' +
                ", foodPrice='" + foodPrice + '\'' +
                ", foodImg='" + foodImg + '\'' +
                '}';
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public void setFoodDes(String foodDes) {
        this.foodDes = foodDes;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public FoodBean(String foodId, String businessId, String foodName, String foodDes, String foodPrice, String foodImg) {
        this.foodId = foodId;
        this.businessId = businessId;
        this.foodName = foodName;
        this.foodDes = foodDes;
        this.foodPrice = foodPrice;
        this.foodImg = foodImg;
    }

    public FoodBean() {
    }

    private String foodId;
    private String businessId;
    private String foodName;
    private String foodDes;
    private String foodPrice;
    private String foodImg;
}
