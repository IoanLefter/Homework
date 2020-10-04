package com.homework.homework8.Ex1;

public class Camera {
    private Dulap dulap;
    private Pat pat;
    private Podea podea;

    public Camera(Dulap dulap, Pat pat, Podea podea) {
        this.dulap = dulap;
        this.pat = pat;
        this.podea = podea;
    }

    public void aflaTipDulap() {
        System.out.println("Caracteristici dulap: ");
        dulap.aflaCaracteristici();
        System.out.println("Numar sertare: " + dulap.getNrSertare());
        System.out.println("Numar umerase: " + dulap.getNrUmerase());
    }

    public void aflaTipPat() {
        System.out.println("Caracteristici pat: ");
        dulap.aflaCaracteristici();
        System.out.println("Tip saltea: " + pat.getTipSaltea());
    }

    public void aflaTipPodea() {
        System.out.println("Caracteristici Podea: ");
        dulap.aflaCaracteristici();
        System.out.println("Tip incalzire in pardoseala: " + podea.getTipIncalzireInPardosea());
    }

    public Dulap getDulap() {
        return dulap;
    }

    public void setDulap(Dulap dulap) {
        this.dulap = dulap;
    }

    public Pat getPat() {
        return pat;
    }

    public void setPat(Pat pat) {
        this.pat = pat;
    }

    public Podea getPodea() {
        return podea;
    }

    public void setPodea(Podea podea) {
        this.podea = podea;
    }
}
