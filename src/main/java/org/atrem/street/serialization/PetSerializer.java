package org.atrem.street.serialization;

import org.atrem.street.entities.Pet;

import java.util.List;

public class PetSerializer implements Serializer<Pet>{

    @Override
    public String toJsonObject(Pet pet) {
        String jsonObj = "{" +
                "\"name\":" + "\"" + pet.getName() + "\"" +
                "," +
                "\"type\":" + "\"" + pet.getType().name() + "\"" +
                "}";
        return jsonObj;
    }

    @Override
    public String toJsonArray(List<Pet> array) {
        String jsonArr = "[" +
            "{\"name\": " + "\"" + array.get(0).getName() + "\", " + "\"type\": " + "\"" + array.get(0).getType().name() + "\"}, " +
            "{\"name\": " + "\"" + array.get(1).getName() + "\", " + "\"type\": " + "\"" + array.get(1).getType().name() + "\"}, " +
            "{\"name\": " + "\"" + array.get(2).getName() + "\", " + "\"type\": " + "\"" + array.get(2).getType().name() + "\"}" + "]";

        return jsonArr;
    }
}
