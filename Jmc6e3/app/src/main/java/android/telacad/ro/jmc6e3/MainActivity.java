package android.telacad.ro.jmc6e3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc6e3.model.ComicResponse;
import android.telacad.ro.jmc6e3.service.ComicService;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView view;
    private ComicService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (ImageView) findViewById(R.id.comic);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://xkcd.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ComicService.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Random r = new Random();
        Call<ComicResponse> response = service.getComic(r.nextInt(1000) + 1);
        response.enqueue(new Callback<ComicResponse>() {
            @Override
            public void onResponse(Call<ComicResponse> call, Response<ComicResponse> response) {
                String img = response.body().getImg();
                Log.i("MAIN", "IMAGE " + img);
                new GetImageAsync().execute(img);
            }

            @Override
            public void onFailure(Call<ComicResponse> call, Throwable t) {
                Log.e("MAIN", "ERROR", t);
            }
        });
    }

    private class GetImageAsync extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL uri = new URL(params[0]);
                Bitmap b = BitmapFactory.decodeStream(uri.openStream());
                return b;
            } catch (Exception e) {
                Log.e("MAIN", "ERROR", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            view.setImageBitmap(bitmap);
        }
    }
}
