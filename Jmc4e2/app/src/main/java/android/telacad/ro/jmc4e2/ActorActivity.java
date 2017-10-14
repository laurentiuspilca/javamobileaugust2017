package android.telacad.ro.jmc4e2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActorActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<Actor> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);
        list=(ListView)findViewById(R.id.actor_list);
        adapter=new ArrayAdapter<Actor>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        adapter.add(new Actor("1"));
        adapter.add(new Actor("2"));
        adapter.add(new Actor("3"));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Actor a=adapter.getItem(position);
                Intent result =new Intent();
                result.putExtra("actor",a);
                setResult(1,result);
                finish();
            }
        });
    }
}
