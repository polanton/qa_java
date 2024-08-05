package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Family family;

    public Lion(String sex, Feline feline) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
            this.family = feline;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
            this.family = feline;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return family.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return family.getFood();
    }
}
