package android.telacad.ro.jmc3e5;

/**
 * Created by student on 9/2/2017.
 */

public class DataContainer {
    private String nume;

    private  DataContainer(){
    }

    private static final class SingletonHolder{
        private static final DataContainer INSTANCE=new DataContainer();
    }

    public static DataContainer getInstance(){
        return  SingletonHolder.INSTANCE;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
