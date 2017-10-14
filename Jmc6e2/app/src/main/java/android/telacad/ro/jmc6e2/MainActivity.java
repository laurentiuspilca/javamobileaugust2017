package android.telacad.ro.jmc6e2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc6e2.model.Article;
import android.telacad.ro.jmc6e2.model.NewsResponse;
import android.telacad.ro.jmc6e2.service.NewsService;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;

    private NewsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(NewsService.class);

        Call<NewsResponse> news = service.getNews();
        news.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                List<Article> articles = response.body().getArticles();
                adapter.clear();
                for (Article a : articles) {
                    adapter.add(a.getTitle());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("MAIN", "ERROR", t);
            }
        });
    }
}
