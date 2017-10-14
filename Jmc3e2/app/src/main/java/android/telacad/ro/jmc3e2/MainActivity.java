package android.telacad.ro.jmc3e2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<Persoana> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.list1);
        adapter=new ArrayAdapter<Persoana>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        Persoana a1=new Persoana("Jon","Snow");

        Persoana a2=new Persoana("Daenerys","Targaryen");

        Persoana a3=new Persoana("Cersei","Lannister");

        adapter.addAll(a1,a2,a3);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persoana a = adapter.getItem(position);
                Intent intent=new Intent(MainActivity.this,Second_Activity.class);
                intent.putExtra("persoana",a);
                startActivity(intent);
            }
        });
    }
}