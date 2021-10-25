package org.atrem.street.serialization;

import java.util.List;

public interface Serializer<T> {
    String toJsonObject(T obj);

    String toJsonArray(List<T> array);
}
