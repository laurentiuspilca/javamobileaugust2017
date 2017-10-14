package android.telacad.ro.jmc1e2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSayHello;
    private EditText txtNume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNume=(EditText)findViewById(R.id.editTextName);
        btnSayHello=(Button)findViewById(R.id.btnSayHello);
        btnSayHello.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg="Hello, "+txtNume.getText().toString()+"!";
                        Log.e("MainActivity","Se va afisa um toast cu mesajul:"+msg);
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
