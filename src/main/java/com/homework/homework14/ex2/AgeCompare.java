package com.homework.homework14.ex2;

import java.util.Comparator;

public class AgeCompare implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
