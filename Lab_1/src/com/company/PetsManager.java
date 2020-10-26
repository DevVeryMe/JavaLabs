package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetsManager
{
    class PetComparatorByFoodQuantity implements Comparator<Pet>
    {
        @Override
        public int compare(Pet pet1, Pet pet2) {
            return Double.compare(pet1.getFoodQuantityPerMonthInKg(), pet2.getFoodQuantityPerMonthInKg());
        }
    }

    static class PetComparatorByPrice implements Comparator<Pet>
    {
        @Override
        public int compare(Pet pet1, Pet pet2) {
            return Double.compare(pet1.getPrice(), pet2.getPrice());
        }
    }

    public List<Pet> findPetsByType(List<Pet> pets, PetType type)
    {
        pets.removeIf(pet -> pet.getPetType() != type);

        return pets;
    }

    public List<Pet> sortByFoodTypeAndQuantity(List<Pet> pets,
                                               FoodType type,
                                               Boolean byDescending)
    {
        pets.removeIf(pet -> pet.getPetFood().getFoodType() != type);

        if (!byDescending)
        {
            pets.sort(new PetComparatorByFoodQuantity());
        }
        else
        {
            pets.sort(Collections.reverseOrder(new PetComparatorByFoodQuantity()));
        }

        return pets;
    }

    public List<Pet> sortByFoodPricePerMonth(List<Pet> pets, Boolean byDescending)
    {
        if (!byDescending)
        {
            pets.sort(new Comparator<Pet>() {
                @Override
                public int compare(Pet p1, Pet p2) {
                    return Double.compare(p1.calculateFoodPricePerMonth(), p2.calculateFoodPricePerMonth());
                }
            });
        }
        else
        {
            pets.sort(Collections.reverseOrder(new Comparator<Pet>() {
                @Override
                public int compare(Pet p1, Pet p2) {
                    return Double.compare(p1.calculateFoodPricePerMonth(), p2.calculateFoodPricePerMonth());
                }
            }));
        }

        return pets;
    }

    public List<Pet> sortByPetPrice(List<Pet> pets, Boolean byDescending)
    {
        if (!byDescending)
        {
            pets.sort(new PetComparatorByPrice());
        }
        else
        {
            pets.sort(Collections.reverseOrder(new PetComparatorByPrice()));
        }

        return pets;
    }

    public List<Pet> sortByPetWeight(List<Pet> pets, Boolean byDescending)
    {
        Comparator<Pet> byWeight =
                (Pet p1, Pet p2)-> Double.compare(p1.getWeightInKg(), p2.getWeightInKg());

        if (!byDescending)
        {
            pets.sort(byWeight);
        }
        else
        {
            pets.sort(Collections.reverseOrder(byWeight));
        }

        return pets;
    }
}
