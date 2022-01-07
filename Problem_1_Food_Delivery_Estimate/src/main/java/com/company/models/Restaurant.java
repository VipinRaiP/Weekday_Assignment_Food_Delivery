package com.company.models;

import java.util.HashMap;

public class Restaurant {
    private Integer totalSlots;
    private Integer maxEstimatedTimeInMinutes;
    private Integer availableSlots;
    private Integer deliveryTimeInMinutesPerKM;
    private HashMap<String,Integer> itemSlotMap;
    private HashMap<String,Integer> itemTimeMap;

    public Restaurant(){
        this.itemSlotMap = new HashMap<>();
        this.itemTimeMap = new HashMap<>();
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    public HashMap<String, Integer> getItemSlotMap() {
        return itemSlotMap;
    }

    public void setItemSlotMap(HashMap<String, Integer> itemSlotMap) {
        this.itemSlotMap = itemSlotMap;
    }

    public HashMap<String, Integer> getItemTimeMap() {
        return itemTimeMap;
    }

    public void setItemTimeMap(HashMap<String, Integer> itemTimeMap) {
        this.itemTimeMap = itemTimeMap;
    }

    public void addToItemSlotMap(String item,Integer slot){
        this.itemSlotMap.put(item,slot);
    }

    public void addToItemTimeMap(String item,Integer time){
        this.itemTimeMap.put(item,time);
    }

    public Integer getMaxEstimatedTimeInMinutes() {
        return maxEstimatedTimeInMinutes;
    }

    public void setMaxEstimatedTimeInMinutes(Integer maxEstimatedTimeInMinutes) {
        this.maxEstimatedTimeInMinutes = maxEstimatedTimeInMinutes;
    }

    public Integer getAvailableSlots() {
        return availableSlots;
    }

    public Integer getDeliveryTimeInMinutesPerKM() {
        return deliveryTimeInMinutesPerKM;
    }

    public void setDeliveryTimeInMinutesPerKM(Integer deliveryTimeInMinutesPerKM) {
        this.deliveryTimeInMinutesPerKM = deliveryTimeInMinutesPerKM;
    }

    public void setAvailableSlots(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }
}
