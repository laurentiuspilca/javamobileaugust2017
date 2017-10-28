package android.telacad.ro.jmc8e1.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by student on 10/28/2017.
 */

public class MyService extends IntentService {

    public MyService() {
        super("My service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i=0; i<100; i++) {
            Log.d("MyService", "A fost afisat " + i);

            Intent inte = new Intent("android.telacad.ro.jmc8e1.service");
            inte.putExtra("numar", i);
            sendBroadcast(inte);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e("MyService", e.getMessage(), e);
            }
        }
    }

}
