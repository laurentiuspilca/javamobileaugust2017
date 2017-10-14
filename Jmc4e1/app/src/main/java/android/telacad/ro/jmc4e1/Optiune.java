package android.telacad.ro.jmc4e1;

/**
 * Created by student on 9/16/2017.
 */

public class Optiune {

    private String nume;
    private boolean activ;

    public String getNume() {
        return nume;
    }

    public Optiune() {
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

    public Optiune(String nume, boolean activ) {
        this.nume = nume;
        this.activ = activ;
    }
}
