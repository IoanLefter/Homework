package com.homework.homework8.Ex2;

public class HealthyBurger extends Hamburger {
    private String healthyAdditional1;
    private double healthyAdditional1price;
    private String healthyAdditional2;
    private double healthyAdditional2price;
    private int numberOfHealthyAdditional;

    public HealthyBurger(String meat, double price) {
        super(meat, price);
        super.setBreadRollType("Brown rye bread roll");
    }

    public void addHealthyAdditional(String additional1, double price1) {
        this.healthyAdditional1 = additional1;
        this.healthyAdditional1price = price1;
        numberOfHealthyAdditional = 1;
    }

    public void addHealthyAdditional(String additional1, double price1, String additional2, double price2) {
        this.healthyAdditional1 = additional1;
        this.healthyAdditional1price = price1;
        this.healthyAdditional2 = additional2;
        this.healthyAdditional2price = price2;
        numberOfHealthyAdditional = 2;
    }

    public void getHealthyAdditional() {
        switch (numberOfHealthyAdditional) {
            case 1:
                System.out.println("Additional ingredient: " + healthyAdditional1 + " price of it " + healthyAdditional1price);
                break;
            case 2:
                System.out.println("Additional ingredient: " + healthyAdditional1 + " price of it " + healthyAdditional1price);
                System.out.println("Additional ingredient: " + healthyAdditional2 + " price of it " + healthyAdditional2price);
                break;
        }
    }

    public void orderDetails() {
        System.out.println("You have ordered a HealthyBurger with base price: " + super.getPrice());
        getAdditional();
        getHealthyAdditional();
        System.out.println("Total price: " + (super.getPrice() + super.getPrice1() + super.getPrice2() + super.getPrice3() + super.getPrice4() + healthyAdditional1price + healthyAdditional2price));
    }
}
