package com.homework.homework14.ex2;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Mihai", 23);
        Person p2 = new Person("Radu", 19);
        Person p3 = new Person("Andrei", 32);
        Person p4 = new Person("Marius", 28);
        TreeSet<Person> persons = new TreeSet<>(new NameCompare());

        //Add Persoane to the TreeSet;
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        //iterate through the set and print the name and the age;
        for (Person next : persons) {
            System.out.println(next);
        }

        //find the oldest and the youngest person in the group.
        System.out.println();
        TreeSet<Person> persons2 = new TreeSet<>(new AgeCompare());
        persons2.addAll(persons);
        System.out.println("Youngest person is "+persons2.first().getName());
        System.out.println("Oldest person is "+persons2.last().getName());
    }
}

