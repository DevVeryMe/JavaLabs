package com.company;

public class Pet
{
    private final PetType petType;
    private final PetFood petFood;
    private final double foodQuantityPerMonthInKg;
    private final int age;
    private final double weightInKg;
    private final String speciesName;
    private final double price;

    public Pet(
            PetType petType,
            PetFood petFood,
            double foodQuantityPerMonthInKg,
            int age,
            double weightInKg,
            String speciesName,
            double price)
    {
        this.petType = petType;
        this.petFood = petFood;
        this.foodQuantityPerMonthInKg = foodQuantityPerMonthInKg;
        this.age = age;
        this.weightInKg = weightInKg;
        this.speciesName = speciesName;
        this.price = price;
    }

    public PetType getPetType() {
        return petType;
    }

    public PetFood getPetFood() {
        return petFood;
    }

    public double getFoodQuantityPerMonthInKg() {
        return foodQuantityPerMonthInKg;
    }

    public int getAge() {
        return age;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public double getPrice() {
        return price;
    }

    public double calculateFoodPricePerMonth()
    {
        return foodQuantityPerMonthInKg * petFood.getPricePerKg();
    }

    @Override
    public String toString() {
        String petType = this.petType.toString();
        String petFood = this.petFood.toString();
        String foodQuantityPerMonthInKg = Double.toString(this.foodQuantityPerMonthInKg);
        String age = Integer.toString(this.age);
        String weightInKg = Double.toString(this.weightInKg);
        String speciesName = this.speciesName;
        String price = Double.toString(this.price);

        return "Pet type: " + petType + "\nPet food: "
                + petFood + "\nFood quantity per month in kg: "
                + foodQuantityPerMonthInKg + "\nAge: "
                + age + "\n Weight in kg: "
                + weightInKg + "\nSpecies name: "
                + speciesName + "\nPrice: "
                + price + "\n";
    }
}
