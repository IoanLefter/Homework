package main.java.com.homework.homework8.Ex1;

public class CaracteristiciElementeCamera {
    private double lungime;
    private double latime;
    private double inaltime;
    private String culoare;
    private String material;

    public CaracteristiciElementeCamera(double lungime, double latime, double inaltime, String culoare, String material) {
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
        this.culoare = culoare;
        this.material = material;
    }

    public double aflaSuprafata() {
        return lungime * latime;
    }

    public double getLungime() {
        return lungime;
    }

    public void aflaCaracteristici() {
        System.out.println("Inaltime: " + getInaltime());
        System.out.println("Latime: " + getLatime());
        System.out.println("Material: " + getLungime());
        System.out.println("Culoare: " + getLungime());
    }

    public void setLungime(double lungime) {
        this.lungime = lungime;
    }

    public double getLatime() {
        return latime;
    }

    public void setLatime(double latime) {
        this.latime = latime;
    }

    public double getInaltime() {
        return inaltime;
    }

    public void setInaltime(double inaltime) {
        this.inaltime = inaltime;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
