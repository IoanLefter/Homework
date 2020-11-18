package main.java.com.homework.homework8.Ex1;

public class Pat extends CaracteristiciElementeCamera {
    private String tipSaltea;

    public Pat(double lungime, double latime, double inaltime, String culoare, String material, String tipSaltea) {
        super(lungime, latime, inaltime, culoare, material);
        this.tipSaltea = tipSaltea;
    }

    public void deCatePersoane() {
        if (super.getLungime() < 1.2) {
            System.out.println("Patul este de o persoana.");
        } else {
            System.out.println("Patul este de doua persoane.");
        }

    }

    public String getTipSaltea() {
        return tipSaltea;
    }

    public void setTipSaltea(String tipSaltea) {
        this.tipSaltea = tipSaltea;
    }
}
