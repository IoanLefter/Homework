package main.java.com.homework.homework8.Ex2;

public class MainEx2 {
    public static void main(String[] args) {
        Hamburger normal = new Hamburger("White", "beef", 22);
        normal.addAdditional("lettuce", 2, "tomato", 3);
        normal.orderDetails();

        System.out.println("healthyBurger--------------------------------------------------------------");
        HealthyBurger healthyBurger = new HealthyBurger("beef", 35);
        System.out.println(healthyBurger.getBreadRollType());
        healthyBurger.addAdditional("tomato", 3);
        healthyBurger.addHealthyAdditional("spinach", 4, "asparagus", 6);
        healthyBurger.orderDetails();

        System.out.println("DeluxeHamburger--------------------------------------------------------------");
        DeluxeHamburger deluxe = new DeluxeHamburger(normal);
        deluxe.addAdditional("Fanta", 8, "Fries", 5);
        deluxe.orderDetails();


    }


}
