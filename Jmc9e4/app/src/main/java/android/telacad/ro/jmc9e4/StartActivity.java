package android.telacad.ro.jmc9e4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    private EditText txtIp;
    private Button btnClient;
    private Button btnServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip = txtIp.getText().toString();
                goToMain(ip);
            }
        });

        btnServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain(null);
            }
        });
    }

    private void goToMain(String ip) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        if(ip != null) intent.putExtra("ip", ip);
        startActivity(intent);
    }
}
