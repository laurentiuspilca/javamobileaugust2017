package android.telacad.ro.jmc5e1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc5e1.DAO.FilmDao;
import android.telacad.ro.jmc5e1.Managers.DBManager;
import android.telacad.ro.jmc5e1.Model.Film;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  DBManager manager;
    private FilmDao filmDao;
    private EditText titlu,descriere,regizor;
    private Button btnAdd, btnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titlu=(EditText)findViewById(R.id.titlu_et);
        descriere=(EditText)findViewById(R.id.descriere_et);
        regizor=(EditText)findViewById(R.id.regizor_et);
        btnAdd=(Button)findViewById(R.id.buton1);
        btnView=(Button)findViewById(R.id.buton2);
        manager=new DBManager(MainActivity.this);
        filmDao=new FilmDao(manager);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=titlu.getText().toString();
                String d=descriere.getText().toString();
                String r=regizor.getText().toString();

                Film film=new Film();
                film.setDescriere(d);
                film.setRegizor(r);
                film.setTitlu(t);

                filmDao.adaugaFilm(film);
                Toast.makeText(MainActivity.this,"A fost adaugat filmul "+t,Toast.LENGTH_LONG).show();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
