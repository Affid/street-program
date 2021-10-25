package org.atrem.street.entities;

public class Pet {
    private final String name;
    private final AnimalType type;

    public Pet(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }
}
