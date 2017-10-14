package android.telacad.ro.jmc5e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc5e1.Adapters.FilmAdapter;
import android.telacad.ro.jmc5e1.DAO.FilmDao;
import android.telacad.ro.jmc5e1.Managers.DBManager;
import android.telacad.ro.jmc5e1.Model.Film;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ListView list;
    private FilmAdapter adapter;
    private DBManager dbManager;
    private FilmDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        list=(ListView)findViewById(R.id.list);
        adapter=new FilmAdapter(this);
        list.setAdapter(adapter);

        afisareFilme();
    }
    public void afisareFilme(){
        dbManager=new DBManager(this);
        dao=new FilmDao(dbManager);
        List<Film> filme=dao.getFilme();
        for (Film c:filme)
        {
            adapter.addFilm(c);
        }
    }
}
