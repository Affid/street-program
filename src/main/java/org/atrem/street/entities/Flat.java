package org.atrem.street.entities;

import java.awt.*;
import java.util.ArrayList;

public class Flat {
    private final int number;
    private ArrayList listOfHuman;

    public Flat(int number, ArrayList listOfHuman){
        this.number = number;
        this.listOfHuman = listOfHuman;
    }

    public int getNumber(){
        return number;
    }

    public ArrayList getListOfHuman(int index){
        return (ArrayList) listOfHuman.get(index);
    }
}
