package main.java.com.homework.homework8.Ex2;

public class Hamburger {
    private String breadRollType;
    private String meat;
    private double price;
    private String additional1;
    private double price1;
    private String additional2;
    private double price2;
    private String additional3;
    private double price3;
    private String additional4;
    private double price4;
    private int numberOfAdditional;


    public Hamburger(String breadRollType, String meat, double price) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
    }

    public Hamburger(String meat, double price) {
        this.meat = meat;
        this.price = price;
    }

    public void addAdditional(String additional1, double price1) {
        this.additional1 = additional1;
        this.price1 = price1;
        numberOfAdditional = 1;
    }

    public void addAdditional(String additional1, double price1, String additional2, double price2) {
        this.additional1 = additional1;
        this.price1 = price1;
        this.additional2 = additional2;
        this.price2 = price2;
        numberOfAdditional = 2;
    }

    public void addAdditional(String additional1, double price1, String additional2, double price2, String additional3, double price3) {
        this.additional1 = additional1;
        this.price1 = price1;
        this.additional2 = additional2;
        this.price2 = price2;
        this.additional2 = additional2;
        this.price3 = price3;
        numberOfAdditional = 3;
    }

    public void addAdditional(String additional1, double price1, String additional2, double price2, String additional3, double price3, String additional4, double price4) {
        this.additional1 = additional1;
        this.price1 = price1;
        this.additional2 = additional2;
        this.price2 = price2;
        this.additional2 = additional2;
        this.price3 = price3;
        this.additional4 = additional4;
        this.price4 = price4;
        numberOfAdditional = 4;
    }

    public void getAdditional() {
        switch (numberOfAdditional) {
            case 1:
                System.out.println("Additional ingredient: " + additional1 + " price of it " + price1);
                break;
            case 2:
                System.out.println("Additional ingredient: " + additional1 + " price of it " + price1);
                System.out.println("Additional ingredient: " + additional2 + " price of it " + price2);
                break;
            case 3:
                System.out.println("Additional ingredient: " + additional1 + " price of it " + price1);
                System.out.println("Additional ingredient: " + additional2 + " price of it " + price2);
                System.out.println("Additional ingredient: " + additional3 + " price of it " + price3);
                break;
            case 4:
                System.out.println("Additional ingredient: " + additional1 + " price of it " + price1);
                System.out.println("Additional ingredient: " + additional2 + " price of it " + price2);
                System.out.println("Additional ingredient: " + additional3 + " price of it " + price3);
                System.out.println("Additional ingredient: " + additional4 + " price of it " + price4);
                break;
        }
    }

    public void orderDetails() {
        System.out.println("You have ordered a hamburger with base price: " + price);
        getAdditional();
        System.out.println("Total price: " + (price + price1 + price2 + price3 + price4));
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public String getAdditional1() {
        return additional1;
    }

    public double getPrice1() {
        return price1;
    }

    public String getAdditional2() {
        return additional2;
    }

    public double getPrice2() {
        return price2;
    }

    public String getAdditional3() {
        return additional3;
    }

    public double getPrice3() {
        return price3;
    }

    public String getAdditional4() {
        return additional4;
    }

    public double getPrice4() {
        return price4;
    }

    public int getNumberOfAdditional() {
        return numberOfAdditional;
    }

    public void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
