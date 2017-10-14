package android.telacad.ro.jmc5e2.model;

        import com.j256.ormlite.field.DatabaseField;
        import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by student on 9/23/2017.
 */
@DatabaseTable(tableName = "persoana")
public class Persoana {
    @DatabaseField(generatedId=true)
    private int id;
    @DatabaseField
    private String nume;
    @DatabaseField
    private String adresa;

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
