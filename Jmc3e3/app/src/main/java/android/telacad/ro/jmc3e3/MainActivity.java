package android.telacad.ro.jmc3e3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private  AngajatAdaptor adaptor;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.list);
        adaptor=new AngajatAdaptor(this);
        list.setAdapter(adaptor);

        Angajat a1=new Angajat("Gigel","Progrmator");
        adaptor.addAngajat(a1);

        Angajat a2=new Angajat("Mirel","System Engineer");
        adaptor.addAngajat(a2);

        Angajat a3=new Angajat("Dorel","Tester");
        adaptor.addAngajat(a3);
    }
}
