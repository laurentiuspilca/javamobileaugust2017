package android.telacad.ro.jmc5e2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc5e2.manager.DBManager;
import android.telacad.ro.jmc5e2.model.Persoana;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Persoana pp=new Persoana();
        pp.setNume("Ion Pop");
        pp.setAdresa("Piata Victoriei");

        DBManager manager=new DBManager(this);
        Dao<Persoana,Integer> persoanaDao=manager.getPersoanaDao();

        try{
            persoanaDao.create(pp);
            List<Persoana> listaPersoane=persoanaDao.queryForAll();
            Persoana p=persoanaDao.queryForId(3);
            List<Persoana> ListaDePersoaneCuNumeDat=persoanaDao.queryForEq("nume","Ion Pop");

            p.setAdresa("Piata Romana");
            persoanaDao.update(p);

            persoanaDao.delete(p);
        }catch (SQLException ee){
            Log.e("eroare",ee.getMessage());
        }
    }
}
