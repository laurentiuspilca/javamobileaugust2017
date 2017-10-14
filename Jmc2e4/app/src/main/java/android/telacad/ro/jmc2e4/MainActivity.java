package android.telacad.ro.jmc2e4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TimePicker picker;
    private Button btnApasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picker =(TimePicker)findViewById(R.id.picker);
        btnApasa=(Button)findViewById(R.id.btnAlege);
        btnApasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alegeOra();
            }
        });
    }
    public void alegeOra(){
        String s="Ai ales ora ";
        s+= picker.getHour()+":"+ picker.getMinute();
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
    }
}
