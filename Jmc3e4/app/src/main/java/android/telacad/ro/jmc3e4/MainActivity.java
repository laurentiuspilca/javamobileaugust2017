package android.telacad.ro.jmc3e4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private  OptiuneAdapter adaptor;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.lista);
        adaptor=new OptiuneAdapter(this);
        list.setAdapter(adaptor);
        Optiune o1=new Optiune("1",true);
        Optiune o2=new Optiune("2",false);
        Optiune o3=new Optiune("3",false);
        Optiune o4=new Optiune("4",true);
        adaptor.addOptiune(o1);
        adaptor.addOptiune(o2);
        adaptor.addOptiune(o3);
        adaptor.addOptiune(o4);

    }
}
