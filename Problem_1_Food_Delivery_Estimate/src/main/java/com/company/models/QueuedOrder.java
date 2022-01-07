package com.company.models;

import java.util.List;

public class QueuedOrder {
    private Integer orderId;
    private List<String> meals;
    private Float distance;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void setMeals(List<String> meals) {
        this.meals = meals;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "QueuedOrder{" +
                "orderId=" + orderId +
                ", meals=" + meals +
                ", distance=" + distance +
                '}';
    }
}
