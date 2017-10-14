package android.telacad.ro.jmc5e3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc5e3.manager.DBManager;
import android.telacad.ro.jmc5e3.model.Persoana;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText numeET,adresaET;
    private Button butonAdauga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butonAdauga=(Button)findViewById(R.id.buton);
        numeET=(EditText)findViewById(R.id.numeET);
        adresaET=(EditText)findViewById(R.id.adresaET);

        butonAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBManager manager=new DBManager(MainActivity.this);
                Dao<Persoana,Integer> persoanaDao=manager.getPersoanaDao();
                try{
                    Persoana p=new Persoana();
                    p.setNume(numeET.getText().toString());
                    p.setAdresa(adresaET.getText().toString());
                    persoanaDao.create(p);
                    long nr= persoanaDao.countOf();
                    Toast.makeText(MainActivity.this,"Exista "+ nr +" persoane in baza de date", Toast.LENGTH_LONG).show();
                }catch (SQLException ee){
                    Log.e("eroare",ee.getMessage());
                }
            }
        });
    }
}
