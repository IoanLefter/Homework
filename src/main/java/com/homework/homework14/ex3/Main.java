package com.homework.homework14.ex3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Ana", 24);
        Person p2 = new Person("Marius", 28);


        Address parkX = new Address("Str. X, Nr.2");
        Address parkZ = new Address("Str. Z, Nr.3");
        Address buildingY = new Address("Str. Y, Nr.1");
        Address buildingX = new Address("Str. XQ, Nr.32");

        List<Address> swimmingLocations = new ArrayList<>();
        swimmingLocations.add(parkX);
        swimmingLocations.add(parkZ);

        List<Address> hikingLocations = new ArrayList<>();
        hikingLocations.add(parkX);
        hikingLocations.add(parkX);
        hikingLocations.add(buildingY);
        hikingLocations.add(buildingX);

        List<Address> cyclingLocations = new ArrayList<>();
        cyclingLocations.add(parkX);
        cyclingLocations.add(parkZ);

        Hobby swimming=new Hobby("swimming",3,swimmingLocations);
        Hobby cycling = new Hobby("cycling",2,cyclingLocations);
        Hobby hiking=new Hobby("hiking",1,hikingLocations);

        List<Hobby> anaHobby = new ArrayList<>();
        anaHobby.add(swimming);
        anaHobby.add(cycling);

        List<Hobby> mariusHobby = new ArrayList<>();
        mariusHobby.add(hiking);
        mariusHobby.add(cycling);

        HashMap<Person,List<Hobby>> hobbiesOfPerson=new HashMap<>();
        hobbiesOfPerson.put(p1,anaHobby);
        hobbiesOfPerson.put(p2,mariusHobby);

        System.out.print(hobbiesOfPerson);


    }
}
