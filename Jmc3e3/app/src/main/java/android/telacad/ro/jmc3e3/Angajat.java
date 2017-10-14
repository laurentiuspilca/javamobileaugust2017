package android.telacad.ro.jmc3e3;

/**
 * Created by student on 9/2/2017.
 */

public class Angajat {
    private String nume;
    private String functie;

    public Angajat() {
    }

    public Angajat(String nume, String functie) {
        this.nume = nume;
        this.functie = functie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }
}
