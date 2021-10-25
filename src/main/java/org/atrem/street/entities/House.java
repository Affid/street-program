package org.atrem.street.entities;

import java.awt.*;

public class House {
    private final int number;
    private List listOfFlats;

    public House(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
