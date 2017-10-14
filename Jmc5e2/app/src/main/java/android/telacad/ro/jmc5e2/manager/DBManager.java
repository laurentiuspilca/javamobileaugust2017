package android.telacad.ro.jmc5e2.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.telacad.ro.jmc5e2.model.Persoana;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by student on 9/23/2017.
 */

public class DBManager extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME="example.db";
    private static final int DATABASE_VERSION=1;

    public DBManager(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            //TableUtils.createTable(connectionSource, Persoana.class);
            TableUtils.createTableIfNotExists(connectionSource, Persoana.class);
        } catch (SQLException e) {
            Log.e("createtable",e.getMessage());//in cazul in care nu aputut crea tabela arunca exceptie
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Persoana,Integer> getPersoanaDao(){
        try{
            return getDao(Persoana.class);
        }catch (SQLException e){
            Log.e("createtable",e.getMessage());
        }
        return null;
        //am creat un dao pe baza clasei, referentiat prin interfata Dao ce contine clasa si id-ul
        //=> nu mai tb sa cream dao-ul
        //e creat unul cu fff multe metode default
    }
}
