package android.telacad.ro.jmc3e5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list=(ListView)findViewById(R.id.list);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        adapter.add("Gigel");
        adapter.add("Mirel");
        adapter.add("Ionel");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nume=adapter.getItem(position);
                Intent intent=new Intent();
                intent.putExtra("nume",nume);

                DataContainer.getInstance().setNume(nume); //-> pt multe date sau obiecte ce nu sunt serializabile
               // setResult(1000,intent); //pt date mici transmise intre activitati

                finish();
                //result code e trimis catre activitate dupa apelul lui finish() pt subactivitate
                //in functie de result code stim in ce activitate se duce
            }
        });
    }
}
