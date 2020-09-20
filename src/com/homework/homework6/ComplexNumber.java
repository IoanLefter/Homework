package com.homework.homework6;

public class ComplexNumber {

    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add(double real, double imaginary) {
        this.real += real;
        this.imaginary += imaginary;
    }

    public void add(ComplexNumber NewNumber) {
        this.real += NewNumber.real;
        this.imaginary += NewNumber.imaginary;
    }

    public void subtract(double real, double imaginary) {
        this.real -= real;
        this.imaginary -= imaginary;
    }

    public void subtract(ComplexNumber NewNumber) {
        this.real -= NewNumber.real;
        this.imaginary -= NewNumber.imaginary;
    }


}
