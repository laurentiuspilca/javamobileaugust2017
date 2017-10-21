package android.telacad.ro.jmc7e1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = Arrays.asList("HELLO", "WORLD");
        MyAsyncTask at = new MyAsyncTask();
        at.execute(list);
    }


    private class MyAsyncTask extends AsyncTask<List<String>, Integer, String> {

        @Override
        protected String doInBackground(List<String>... params) {
            List<String> list = params[0];
            String str = "";
            for (String s : list) {
                Log.d("MyAsyncTask", s);
                str += s;
            }
            return str;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("onPostExecute", s);
        }
    }
}
