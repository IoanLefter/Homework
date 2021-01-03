package com.homework.homework13.ex2;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String cnp;

    public Person(String name, String surname, String cnp) {
        this.name = name;
        this.surname = surname;
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                surname.equals(person.surname) &&
                cnp.equals(person.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, cnp);
    }
}
