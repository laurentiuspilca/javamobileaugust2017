package android.telacad.ro.jmc3e1;

/**
 * Created by Ada on 9/2/2017.
 */

public class Artist {
    private String nume;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return nume;
    }
}
