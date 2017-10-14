package android.telacad.ro.jmc5e1.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telacad.ro.jmc5e1.Managers.DBManager;
import android.telacad.ro.jmc5e1.Model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/23/2017.
 */

public class FilmDao {

    private DBManager manager;

    public FilmDao (DBManager manager){
        this.manager=manager;
    }

    public void adaugaFilm(Film film){
        ContentValues cv=new ContentValues();
        cv.put("titlu",film.getTitlu());
        cv.put("descriere",film.getDescriere());
        cv.put("regizor",film.getRegizor());
        SQLiteDatabase db=manager.getWritableDatabase();
        db.insert("film",null,cv);
    }

    public List<Film> getFilme(){
        String sql="SELECT * FROM film";
        List<Film> filme=new ArrayList<>();
        String ssql="SELECT * FROM film";
        SQLiteDatabase db=manager.getReadableDatabase();
        Cursor cursor=db.rawQuery(ssql,null);//null poate fi inlocuit de parametrii dc aveam si WHERE ceva=? in interogare
        if(cursor.moveToFirst()){
            do{
                Film f=new Film();
                f.setId(cursor.getInt(0));
                f.setTitlu(cursor.getString(1));
                f.setDescriere(cursor.getString(2));
                f.setRegizor(cursor.getString(3));
                filme.add(f);
            }while (cursor.moveToNext());
        }
        return filme;
    }
}
