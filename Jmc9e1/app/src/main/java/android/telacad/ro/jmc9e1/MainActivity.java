package android.telacad.ro.jmc9e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new MyWebViewClient());
        webView.addJavascriptInterface(new MyJavascriptInterface(), "myapp");

        webView.loadUrl("http://10.5.1.150:8080/Jmc9e1-server/");
        //String html = "<h1>HELLO WORLD!</h1>";
        //webView.loadData(html, "text/html", "UTF-8");
    }

    private class MyJavascriptInterface {

        @JavascriptInterface
        public void afisareMesaj() {
            Toast.makeText(MainActivity.this, "Ai apast pe link!", Toast.LENGTH_LONG).show();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.getUrl().toString().startsWith("http://www.telacad.ro")) {
                view.loadUrl(request.getUrl().toString());
            }
            return true;
        }
    }
}
