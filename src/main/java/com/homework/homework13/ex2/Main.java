package com.homework.homework13.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ionescu1", "Marian", "1930621123401");
        Person person2 = new Person("Ionescu2", "Marian", "1930621123402");
        Person person3 = new Person("Ionescu3", "Marian", "1930621123403");
        Person person4 = new Person("Ionescu4", "Marian", "1930621123404");
        Person person5 = new Person("Ionescu5", "Marian", "1930621123405");
        Person person6 = new Person("Ionescu6", "Marian", "1930621123406");
        Person person7 = new Person("Ionescu7", "Marian", "1930621123407");
        Person person8 = new Person("Ionescu8", "Marian", "1930621123408");
        Person person9 = new Person("Ionescu9", "Marian", "1930621123409");
        Person person10 = new Person("Bubble", "Stevie", "1930621123410");


        Student student1 = new Student("Ionescu1", "Marian", "1930621123401", "01S");
        Student student2 = new Student("Ionescu2", "Marian", "1930621123402", "02S");
        Student student3 = new Student("Ionescu3", "Marian", "1930621123403", "03S");
        Student student4 = new Student("Ionescu4", "Marian", "1930621123404", "04S");
        Student student5 = new Student("Ionescu5", "Marian", "1930621123405", "05S");
        Employee employee1 = new Employee("Ionescu6", "Marian", "1930621123406", "01E", 3001);
        Employee employee2 = new Employee("Ionescu7", "Marian", "1930621123407", "02E", 3002);
        Employee employee3 = new Employee("Ionescu8", "Marian", "1930621123408", "03E", 3003);
        Employee employee4 = new Employee("Ionescu9", "Marian", "1930621123409", "04E", 3004);
        Employee employee5 = new Employee("Bubble", "Stevie", "1930621123410", "05E", 3005);

        List<Person> persons = new ArrayList<>();

        persons.add(student1);
        persons.add(student2);
        persons.add(student3);
        persons.add(student4);
        persons.add(student5);
        persons.add(employee1);
        persons.add(employee2);
        persons.add(employee3);
        persons.add(employee4);
        persons.add(employee5);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        //Cerinta 2 a
        System.out.println("Cerinta 2 a");
        persons.forEach(p -> System.out.println(p.getName() + " " + p.getSurname()));

        //Cerinta 2 b
        System.out.println();
        System.out.println("Cerinta 2 b");
        checkName(persons, "Bubble", "Stevie");
        checkName(persons, "X", "Stevie");

        //Cerinta 2 c
        System.out.println();
        System.out.println("Cerinta 2 c");
        bonus(employees);

    }

    public static void checkName(List<Person> list, String name, String surname) {

        for (Person next : list) {
            if (name.equals(next.getName()) && surname.equals(next.getSurname())) {
                System.out.println("The person is in the list");
                return;
            }
        }
        System.out.println("The person is NOT in the list");
    }

    public static void bonus(List<Employee> list) {

        for (Employee next : list) {
            next.setSalary(next.getSalary() + 200);
        }
        System.out.println(list);
    }
}
