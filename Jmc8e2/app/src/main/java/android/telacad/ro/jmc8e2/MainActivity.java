package android.telacad.ro.jmc8e2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) findViewById(R.id.password);
        btnOpen = (Button) findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendMessageTask().execute(password.getText().toString());
            }
        });
    }

    private class SendMessageTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            try {
                Socket socket = new Socket("10.5.1.85", 4444);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(params[0]);
            } catch (Exception e) {
                Log.e("SendMessageTask", e.getMessage(), e);
            }
            return null;
        }
    }
}
