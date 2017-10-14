package android.telacad.ro.jmc4e2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SingerActivity extends AppCompatActivity {
    private ListView list;
    private ArrayAdapter<Singer> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer);
        list=(ListView)findViewById(R.id.singer_list);
        adapter=new ArrayAdapter<Singer>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        adapter.add(new Singer("1"));
        adapter.add(new Singer("2"));
        adapter.add(new Singer("3"));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Singer s=adapter.getItem(position);
                Intent result =new Intent();
                result.putExtra("singer",s);
                setResult(2,result);
                finish();
            }
        });
    }
}
