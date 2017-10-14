package android.telacad.ro.jmc4e3.Managers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ada on 9/16/2017.
 */

public class DBManager extends SQLiteOpenHelper {
    private static final String DB_NAME="exemplu.db";
    private static final int VERSION =1; //cand veriunea se schimba, e spelata onUpgrade

    public DBManager(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creaza baza de date
        String create_contact_table="CREATE TABLE contacte ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nume TEXT, "+
                "tel TEXT"+
                ")";
        db.execSQL(create_contact_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ce face cand versiunea se schimba
        db.execSQL("DROP TABLE IF EXISTS contacte");//sterge baza de date
        onCreate(db);//o construieste din nou
        //nu se face asa in practica
    }
}
