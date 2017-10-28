package android.telacad.ro.jmc8e4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText etIp;
    private Button btnBuzz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIp = (EditText) findViewById(R.id.ip);
        btnBuzz = (Button) findViewById(R.id.buzz);

        btnBuzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BuzzAsyncTask().execute(etIp.getText().toString());
            }
        });
    }

    private class BuzzAsyncTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            try {
                Socket socket = new Socket(params[0], 4321);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("buzz");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
