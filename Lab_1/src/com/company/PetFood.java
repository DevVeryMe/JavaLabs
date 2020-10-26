package com.company;

public class PetFood
{
    private final FoodType foodType;
    private final double pricePerKg;

    public PetFood(FoodType foodType, double pricePerKg)
    {
        this.foodType = foodType;
        this.pricePerKg = pricePerKg;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    @Override
    public String toString() {
        String foodType = this.foodType.toString();
        String pricePerKg = Double.toString(this.pricePerKg);

        return  "food type: " + foodType + ", " + "price per kg: " + pricePerKg;
    }
}
