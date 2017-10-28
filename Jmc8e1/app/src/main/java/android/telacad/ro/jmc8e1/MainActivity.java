package android.telacad.ro.jmc8e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc8e1.service.MyService;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnService = (Button) findViewById(R.id.btnService);
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(new MyReceiver(), new IntentFilter("android.telacad.ro.jmc8e1.service"));
    }

    private class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("MainActivity", "Message received " + intent.getIntExtra("numar", -1));
        }
    }
}
