package android.telacad.ro.jmc2e2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private Button btnAlege;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlege=(Button)findViewById(R.id.btnAlege);
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        btnAlege.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                afisare();
            }
        });
    }

    public void afisare(){
        String s="Ai ales: ";
        if(cb1.isChecked())
            s=s+" "+cb1.getText();
        if(cb2.isChecked())
            s=s+" "+cb2.getText();
        if(cb3.isChecked())
            s=s+" "+cb3.getText();
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
    }
}
