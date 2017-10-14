package android.telacad.ro.jmc4e2;

import java.io.Serializable;

/**
 * Created by student on 9/16/2017.
 */

public class Singer  implements Serializable {
    private String nume;

    public Singer(String nume) {
        this.nume = nume;
    }

    public Singer() {
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

