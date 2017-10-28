package android.telacad.ro.jmc8e5;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnNotify;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        btnNotify = (Button) findViewById(R.id.btnNotify);

        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Notification n = new Notification.Builder(MainActivity.this)
                         .setContentTitle("Notification title")
                         .setSmallIcon(R.mipmap.ic_launcher)
                         .setVibrate(new long[]{200,500,200})
                         .build();

                manager.notify(1, n);

            }
        });
    }
}
