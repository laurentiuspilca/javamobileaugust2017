package android.telacad.ro.jmc4e2;

import java.io.Serializable;

/**
 * Created by student on 9/16/2017.
 */

public class Actor implements Serializable{
    private String nume;

    public Actor(String nume) {
        this.nume = nume;
    }

    public Actor() {
    }

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
