package org.atrem.street.serialization;

import org.atrem.street.entities.House;

import java.util.List;

public class HouseSerializer implements Serializer<House>{
    @Override
    public String toJsonObject(House obj) {
        String jsonObj = "{" +
                "\"number\":" + "\"" + obj.getNumber() + "\"" + "}";
        return jsonObj;
    }

    @Override
    public String toJsonArray(List<House> array) {
        return null;
    }
}
