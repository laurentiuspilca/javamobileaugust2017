package android.telacad.ro.jmc2e3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnAlege;
    private RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlege=(Button)findViewById(R.id.btnAlege);
        rb1=(RadioButton)findViewById(R.id.cb1);
        rb2=(RadioButton)findViewById(R.id.cb2);
        rb3=(RadioButton)findViewById(R.id.cb3);
        btnAlege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificaRaspuns();
            }
        });
    }

    private void verificaRaspuns(){
        if(rb2.isChecked())
            Toast.makeText(MainActivity.this,"Corec!",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Gresit!",Toast.LENGTH_LONG).show();

    }
}
