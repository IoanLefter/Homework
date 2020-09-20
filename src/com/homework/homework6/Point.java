package com.homework.homework6;

public class Point {

    int x;
    int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(Math.pow(0 - x, 2) + Math.pow(0 - y, 2));
    }

    public double distance(Point Another) {
        return Math.sqrt(Math.pow(Another.x - x, 2) + Math.pow(Another.y - y, 2));
    }
}
