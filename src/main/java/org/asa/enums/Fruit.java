package org.asa.enums;

public enum Fruit {

    APPLE("Apple", 60),
    ORANGE("Orange", 25);

    private final String name;
    private final int price;

    private Fruit(String name, int price)    {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
