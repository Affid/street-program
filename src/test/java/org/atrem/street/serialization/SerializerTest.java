package org.atrem.street.serialization;

import org.atrem.street.entities.AnimalType;
import org.atrem.street.entities.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SerializerTest {

    @Test
    public void shouldSerializePetObject(){
        Pet pet = new Pet("толя", AnimalType.CAT);
        Serializer<Pet> petSerializer = new PetSerializer();
        String jsonPet = petSerializer.toJsonObject(pet);
        String expected = "{\"name\":\"толя\",\"type\":\"CAT\"}";
        Assertions.assertEquals(expected, jsonPet);
    }

    @Test
    public void shouldSerializePetList(){
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("толя", AnimalType.CAT));
        pets.add(new Pet("шарик", AnimalType.DOG));
        pets.add(new Pet("куку", AnimalType.BIRD));
        Serializer<Pet> petSerializer = new PetSerializer();
        String jsonPetArray = petSerializer.toJsonArray(pets);
        String expected = "[{\"name\": \"толя\", \"type\": \"CAT\"}, {\"name\": \"шарик\", \"type\": \"DOG\"}, {\"name\": \"куку\", \"type\": \"BIRD\"}]";
        Assertions.assertEquals(expected, jsonPetArray);
    }
}
