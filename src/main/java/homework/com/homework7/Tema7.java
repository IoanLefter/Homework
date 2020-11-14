package main.java.homework.com.homework7;

public class Tema7 {
    public static void main(String[] args) {
        Vehicle vehicul1 = new Vehicle();
        vehicul1.moving(22);

        Car masina1 = new Car(200, 150, 400, true, "black", 5, "electric");
        masina1.setNumberOfDoors(0);
        masina1.startEngine();

        vehicul1.steering("left");

        Mercedes benzC = new Mercedes(220, 170, 500, true, "black", 5, "hybrid", "benz C");
        benzC.startEngine();


        System.out.println("Ex 2------------------------------");
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle.width= " + rectangle.getWidth());
        System.out.println("rectangle.length= " + rectangle.getLength());
        System.out.println("rectangle.area= " + rectangle.getArea());
        Cuboid cuboid = new Cuboid(5, 10, 5);
        System.out.println("cuboid.width= " + cuboid.getWidth());
        System.out.println("cuboid.length= " + cuboid.getLength());
        System.out.println("cuboid.area= " + cuboid.getArea());
        System.out.println("cuboid.height= " + cuboid.getHeight());
        System.out.println("cuboid.volume= " + cuboid.getVolume());


    }

}
