package com.company;

public class CarInfo {
    private String model;
    private String price;
    private String maxSpeed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "\nModel: " + model
                + "\nPrice: " + price
                + "\nMax speed km/h: " + maxSpeed;
    }
}
