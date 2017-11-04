package android.telacad.ro.jmc9e4;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ServerSocket ss;
    private CommunicationThread ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.addJavascriptInterface(new MyJavascriptInterface(), "myapp");
        webView.loadUrl("http://10.5.1.150:8080/Jmc9e5-server/");

        Intent receivedIntent = getIntent();
        String ip = receivedIntent.getStringExtra("ip");

        if (ip != null) {
            new ClientAsyncTask().execute(ip);
        } else {
            new ServerAsyncTask().execute();
        }
    }

    private class ClientAsyncTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            try {
                Socket socket = new Socket(params[0], 4444);
                ct = new CommunicationThread(socket);
                ct.start();
            } catch (Exception e) {
                Log.e("ClientAsyncTask", e.getMessage(), e);
            }
            return null;
        }
    }

    private class ServerAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                ss = new ServerSocket(4444);
                while (true) {
                    Socket socket = ss.accept();
                    ct = new CommunicationThread(socket);
                    ct.start();
                }
            } catch (Exception e) {
                Log.e("ServerAyncTask", e.getMessage(), e);
            }
            return null;
        }
    }

    private class CommunicationThread extends Thread {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public CommunicationThread(Socket socket) throws Exception {
            this.socket = socket;
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        public void run() {
            try {
                while (true) {
                    String line = in.readLine();
                    webView.loadUrl("javascript:receive('"+line+"')");
                }
            } catch (Exception e) {
                Log.e("CommunicationThread", e.getMessage(), e);
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }

    private class MyJavascriptInterface {

        @JavascriptInterface
        public void sendMessage(String message) {
            if (ct != null) {
                ct.sendMessage(message);
            } else {
                Toast.makeText(MainActivity.this, "Niciun client conectat!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
