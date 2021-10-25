package org.atrem.street.serialization;

import org.atrem.street.entities.Flat;

import java.util.List;

public class FlatSerializer implements Serializer<Flat>{

    @Override
    public String toJsonObject(Flat flat) {
        String jsonObj = "{" +
                "\"number\":" + "\"" + flat.getNumber() + "\"" + "}";
        return jsonObj;
    }

    @Override
    public String toJsonArray(List<Flat> array) {
        return null;
    }
}
