package main.java.homework.com.homework7;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String engineType;

    public Car(double width, double height, double length, boolean has_engine, String colour, int numberOfDoors, String engineType) {
        super(width, height, length, has_engine, colour);
        this.numberOfDoors = numberOfDoors;
        this.engineType = engineType;
    }

    public void changingGears(int gearNumber) {
        System.out.println("You are in gear number " + gearNumber);
    }

    public void startEngine() {
        System.out.println("Engine is started");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors > 0) {
            this.numberOfDoors = numberOfDoors;
        } else {
            System.out.println("Number of doors should be greater than zero");
        }


    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
