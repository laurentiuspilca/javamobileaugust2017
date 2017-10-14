package android.telacad.ro.jmc5e1.Managers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 9/23/2017.
 */

public class DBManager extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME="filme.db";
    private static final int DATABASE_VERSION=1;

    public DBManager(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTAbleFilm="CREATE TABLE film ("+"id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "titlu TEXT, "+"descriere TEXT, "+"regizor TEXT"+")";
        db.execSQL(createTAbleFilm);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
