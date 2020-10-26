package com.company;

import java.util.List;

public class PetStore
{
    private List<Pet> pets;

    public PetStore(List<Pet> pets)
    {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public Boolean sell(Pet pet)
    {
        boolean isSold = false;

        if (pets.contains(pet))
        {
            pets.remove(pet);
            isSold = true;
        }

        return isSold;
    }
}
