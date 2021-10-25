package org.atrem.street.serialization;

import org.atrem.street.entities.Human;

import java.util.List;

public class HumanSerializer implements Serializer<Human>{
    @Override
    public String toJsonObject(Human obj) {
        String jsonObj = "{" +
                "\"lastName\":" + "\"" + obj.getLastName() + "\"" +
                "\"name\":" + "\"" + obj.getName() + "\"" +
                "\"money\":" + "\"" + obj.getMoney() + "\"" +
                "}";
        return jsonObj;
    }

    @Override
    public String toJsonArray(List<Human> array) {
        return null;
    }
}
