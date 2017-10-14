package android.telacad.ro.jmc4e3.Entities;

/**
 * Created by ada on 9/16/2017.
 */

public class Contact {
    private int id;
    private String nume;
    private String tel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {

        return nume+" "+tel;
    }
}
