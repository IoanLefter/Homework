package main.java.com.homework.homework7;

public class Vehicle {
    private double width;
    private double height;
    private double length;
    private boolean has_engine;
    private String colour;


    public Vehicle() {
    }

    public Vehicle(double width, double height, double length, boolean has_engine, String colour) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.has_engine = has_engine;
        this.colour = colour;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isHas_engine() {
        return has_engine;
    }

    public void setHas_engine(boolean has_engine) {
        this.has_engine = has_engine;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void moving(int speed) {
        System.out.println("The vehicle is moving with " + speed + " Km/h");
    }

    public void steering(String direction) {
        System.out.println("Vehicle is steering to the " + direction);
    }
}
