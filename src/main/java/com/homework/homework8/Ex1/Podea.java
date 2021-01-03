package com.homework.homework8.Ex1;

public class Podea extends CaracteristiciElementeCamera {
    private String tipIncalzireInPardosea;


    public Podea(double lungime, double latime, double inaltime, String culoare, String material, String tipIncalzireInPardosea) {
        super(lungime, latime, inaltime, culoare, material);
        this.tipIncalzireInPardosea = tipIncalzireInPardosea;
    }


    public String getTipIncalzireInPardosea() {
        return tipIncalzireInPardosea;
    }

    public void setTipIncalzireInPardosea(String tipIncalzireInPardosea) {
        this.tipIncalzireInPardosea = tipIncalzireInPardosea;
    }
}
