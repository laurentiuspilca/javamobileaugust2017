package android.telacad.ro.jmc4e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        OptiuniAdapter adapter=new OptiuniAdapter(this);
        list.setAdapter(adapter);
        adapter.adaugaOptiune(new Optiune("1",true));
        adapter.adaugaOptiune(new Optiune("2",false));
        adapter.adaugaOptiune(new Optiune("3",false));
        adapter.adaugaOptiune(new Optiune("4",true));
        adapter.adaugaOptiune(new Optiune("5",false));
        adapter.adaugaOptiune(new Optiune("6",true));
        adapter.adaugaOptiune(new Optiune("7",false));
        adapter.adaugaOptiune(new Optiune("8",true));

    }
}
