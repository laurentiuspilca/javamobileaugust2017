package android.telacad.ro.jmc3e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<Artist> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.list1);
        adapter=new ArrayAdapter<Artist>(this, android.R.layout.simple_list_item_1);
        //layout-ul are un singur label pt fiecare element al listei
        list.setAdapter(adapter);

        Artist a1=new Artist();
        a1.setNume("Gigel");

        Artist a2=new Artist();
        a2.setNume("Popel");

        Artist a3=new Artist();
        a3.setNume("Mirel");

        adapter.add(a1);
        adapter.add(a2);
        adapter.add(a3);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist a = adapter.getItem(position);
                Toast.makeText(MainActivity.this, "Ai ales artistul "+a,Toast.LENGTH_LONG).show();
            }
        });
    }
}
