package android.telacad.ro.jmc3e2;

import java.io.Serializable;

/**
 * Created by student on 9/2/2017.
 */

public class Persoana implements Serializable
{
    private String nume, prenume;

    public Persoana() {
    }

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return nume+" "+prenume;
    }
}
