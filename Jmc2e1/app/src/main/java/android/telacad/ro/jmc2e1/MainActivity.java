package android.telacad.ro.jmc2e1;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;
    private Button btnApasa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHello=(TextView)findViewById(R.id.txtHello);
        btnApasa=(Button)findViewById(R.id.btnApasa);
        btnApasa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changeText();
            }
        });
    }

    private void changeText(){
        if(tvHello.getText().toString().equals("HELLO"))
            tvHello.setText("WORLD");
        else
            tvHello.setText("HELLO");
    }
}
