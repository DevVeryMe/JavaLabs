package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Pet> pets = new LinkedList<>();
        pets.add(new Pet(PetType.Amphibian,
                new PetFood(FoodType.AmphibianFood,2.5),
                5.5,
                5,
                5.5,
                "Any",
                100));
        pets.add(new Pet(PetType.Amphibian,
                new PetFood(FoodType.AmphibianFood,2.5),
                3.3,
                3,
                3.3,
                "Any",
                333));
        pets.add(new Pet(PetType.Amphibian,
                new PetFood(FoodType.AmphibianFood,2.5),
                8.5,
                3,
                8.5,
                "Any",
                200));
        pets.add(new Pet(PetType.Amphibian,
                new PetFood(FoodType.AmphibianFood,2.5),
                6.5,
                6,
                6.5,
                "Any",
                150));
        pets.add(new Pet(PetType.Bird,
                new PetFood(FoodType.BirdFood,8.5),
                2.5,
                1,
                0.5,
                "Any",
                500));
        pets.add(new Pet(PetType.Rodent,
                new PetFood(FoodType.RodentFood,1.3),
                3.2,
                1,
                0.3,
                "Any",
                15));
        pets.add(new Pet(PetType.Reptile,
                new PetFood(FoodType.ReptileFood,8.8),
                8,
                8,
                3.3,
                "Any",
                2500));
        pets.add(new Pet(PetType.Rabbit,
                new PetFood(FoodType.RabbitFood,3.3),
                5,
                1,
                0.7,
                "Any",
                80));
        pets.add(new Pet(PetType.Fish,
                new PetFood(FoodType.FishFood,2.2),
                0.3,
                0,
                0.1,
                "Any",
                20));
        pets.add(new Pet(PetType.Dog,
                new PetFood(FoodType.DogFood,6.6),
                8.9,
                4,
                7,
                "Any",
                5000));
        pets.add(new Pet(PetType.Cat,
                new PetFood(FoodType.CatFood,7.3),
                6.8,
                2,
                2.5,
                "Any",
                1500));

        System.out.println("Input list:");
        for (Pet pet: pets)
        {
            System.out.println(pet.toString());
        }

        PetsManager petsManager = new PetsManager();
        PetStore petStore = new PetStore(pets);

        List<Pet> petsByFoodPricePerMonth = petsManager.sortByFoodPricePerMonth(petStore.getPets(), false);

        System.out.println("sortByFoodPricePerMonth list:");
        for (Pet pet: petsByFoodPricePerMonth)
        {
            System.out.println(pet.toString());
        }

        List<Pet> petsByFoodTypeAndQuantity =
                petsManager.sortByFoodTypeAndQuantity(petStore.getPets(), FoodType.AmphibianFood, true);

        System.out.println("sortByFoodTypeAndQuantity by descending list:");
        for (Pet pet: petsByFoodTypeAndQuantity)
        {
            System.out.println(pet.toString());
        }

        List<Pet> petsByPetPrice = petsManager.sortByPetPrice(petStore.getPets(), false);

        System.out.println("sortByPetPrice list:");
        for (Pet pet: petsByPetPrice)
        {
            System.out.println(pet.toString());
        }

        List<Pet> petsByPetWeight = petsManager.sortByPetWeight(petStore.getPets(), false);

        System.out.println("sortByPetWeight list:");
        for (Pet pet: petsByPetWeight)
        {
            System.out.println(pet.toString());
        }

        List<Pet> petsByType = petsManager.findPetsByType(petStore.getPets(), PetType.Amphibian);

        System.out.println("findPetsByType list:");
        for (Pet pet: petsByType)
        {
            System.out.println(pet.toString());
        }
    }
}
