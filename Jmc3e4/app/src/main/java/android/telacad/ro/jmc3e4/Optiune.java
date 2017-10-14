package android.telacad.ro.jmc3e4;

/**
 * Created by student on 9/2/2017.
 */

public class Optiune {
    private String nume;
    private boolean activ;

    public Optiune() {
    }

    public Optiune(String nume, boolean activ) {
        this.nume = nume;
        this.activ = activ;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean isActiv() {
        return activ;
    }

    public void setActiv(boolean activ) {
        this.activ = activ;
    }
}
