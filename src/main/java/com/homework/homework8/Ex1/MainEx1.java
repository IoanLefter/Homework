package com.homework.homework8.Ex1;

public class MainEx1 {
    public static void main(String[] args) {
        Dulap dulap = new Dulap(2, 1, 2, "maro", "lemn", 10, 20);
        Pat pat = new Pat(2, 1.8, 0.3, "alb", "lemn", "saltea cu spuma de memorie si pe arcuri");
        Podea podea = new Podea(3, 4, 0, "maro", "parchet", "Incalzire cu apa");
        Camera dormitor = new Camera(dulap, pat, podea);

        System.out.println("Suprafata totala a camerei este: " + podea.aflaSuprafata() + "m^2");
        System.out.println("Suprafata nefolosita din camera este de: " + (podea.aflaSuprafata() - pat.aflaSuprafata() - dulap.aflaSuprafata()) + "m^2");
        pat.deCatePersoane();
        dormitor.aflaTipDulap();
        dormitor.aflaTipPat();
        dormitor.aflaTipPodea();

    }
}
