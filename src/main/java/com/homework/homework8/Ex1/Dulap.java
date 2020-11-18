package main.java.com.homework.homework8.Ex1;

public class Dulap extends CaracteristiciElementeCamera {
    private int nrSertare;
    private int nrUmerase;

    public Dulap(double lungime, double latime, double inaltime, String culoare, String material, int nrSertare, int nrUmerase) {
        super(lungime, latime, inaltime, culoare, material);
        this.nrSertare = nrSertare;
        this.nrUmerase = nrUmerase;
    }

    public int getNrSertare() {
        return nrSertare;
    }

    public void setNrSertare(int nrSertare) {
        this.nrSertare = nrSertare;
    }

    public int getNrUmerase() {
        return nrUmerase;
    }

    public void setNrUmerase(int nrUmerase) {
        this.nrUmerase = nrUmerase;
    }
}
