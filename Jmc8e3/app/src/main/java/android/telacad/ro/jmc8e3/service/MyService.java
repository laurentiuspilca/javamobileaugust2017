package android.telacad.ro.jmc8e3.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by student on 10/28/2017.
 */

public class MyService extends IntentService {

    private ServerSocket ss;

    public MyService() {
        super("Service");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyService", "Called vibrate");

        try {
            ss = new ServerSocket(4321);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            while (true) {
                Socket socket = ss.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String buzz = in.readLine();

                if ("buzz".equals(buzz)) {
                    v.vibrate(500);
                }

            }
        } catch (Exception e) {
            Log.e("MyService", e.getMessage(), e);
        }
    }
}
