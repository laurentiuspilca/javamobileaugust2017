package android.telacad.ro.jmc3e5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button selecteaza;
    private TextView mesaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selecteaza=(Button)findViewById(R.id.select);
        mesaj=(TextView)findViewById(R.id.mesaj);
        selecteaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                //subactivitate
                startActivityForResult(intent,1);
                //1 = request code; fol pt a sti din ce activitate a fost pornita subactivitatea
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // String nume=data.getStringExtra("nume");
        String nume= DataContainer.getInstance().getNume();
        mesaj.setText("Hello, "+nume+"!");
    }
}
