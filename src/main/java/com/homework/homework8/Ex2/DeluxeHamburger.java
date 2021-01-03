package com.homework.homework8.Ex2;

public class DeluxeHamburger {
    private Hamburger Hamburger;
    private String drink;
    private double drinkPrice;
    private String chips;
    private double chipsPrice;
    private int withDrinkAndOrChips;

    public DeluxeHamburger(com.homework.homework8.Ex2.Hamburger hamburger) {
        Hamburger = hamburger;
    }

    public void addAdditional(String drink, double drinkPrice) {
        this.drink = drink;
        this.drinkPrice = drinkPrice;
        withDrinkAndOrChips = 1;
    }

    public void addAdditional(String drink, double drinkPrice, String chips, double chipsPrice) {
        this.drink = drink;
        this.drinkPrice = drinkPrice;
        this.chips = chips;
        this.chipsPrice = chipsPrice;
        withDrinkAndOrChips = 2;
    }

    public void getAdditional() {
        switch (withDrinkAndOrChips) {
            case 1:
                System.out.println("Additional ingredient: " + drink + " price of it " + drinkPrice);
                break;
            case 2:
                System.out.println("Additional ingredient: " + drink + " price of it " + drinkPrice);
                System.out.println("Additional ingredient: " + chips + " price of it " + chipsPrice);
                break;
        }
    }

    public void orderDetails() {
        System.out.println("You have ordered a DeluxeHamburger with base price: " + Hamburger.getPrice());
        getAdditional();
        System.out.println("Total price: " + (Hamburger.getPrice() + chipsPrice + drinkPrice));
    }
}
