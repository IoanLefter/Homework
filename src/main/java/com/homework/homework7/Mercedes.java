package main.java.com.homework.homework7;

public class Mercedes extends Car {
    private String Model;

    public Mercedes(double width, double height, double length, boolean has_engine, String colour, int numberOfDoors, String engineType, String model) {
        super(width, height, length, has_engine, colour, numberOfDoors, engineType);
        Model = model;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void startEngine() {
        super.startEngine();
        System.out.println("Your Mercedes is ready for the road");
    }
}
