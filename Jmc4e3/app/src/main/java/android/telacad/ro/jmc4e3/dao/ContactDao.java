package android.telacad.ro.jmc4e3.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.telacad.ro.jmc4e3.Entities.Contact;
import android.telacad.ro.jmc4e3.Managers.DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/16/2017.
 */

public class ContactDao {
    private static  final String CONTACTE="contacte";
    private DBManager dbManager;
    public ContactDao(DBManager dbManager){
        this.dbManager=dbManager;
    }
    public void adaugaContact(Contact contact){
        SQLiteDatabase db=dbManager.getWritableDatabase();
        ContentValues record=new ContentValues();//map
        record.put("nume",contact.getNume());
        record.put("tel",contact.getTel());
        db.insert(CONTACTE, null, record);//nu mai tb sa scriem interogarile; folosim doar aceasta metoda
    }
    public List<Contact> getContacte(){
        List<Contact> contacts=new ArrayList<>();
        String sql="SELECT * FROM "+CONTACTE;
        SQLiteDatabase db=dbManager.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Contact c=new Contact();
                c.setId(cursor.getInt(0));
                c.setNume(cursor.getString(1));
                c.setTel(cursor.getString(2));
                contacts.add(c);
            }while (cursor.moveToNext());
        }
        return  contacts;
    }
}
