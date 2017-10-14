package android.telacad.ro.jmc6e2.service;

import android.telacad.ro.jmc6e2.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by student on 10/14/2017.
 */

public interface NewsService {

    @GET("v1/articles?source=abc-news-au&apiKey=2ecf7a8f8583401fa680efa914abf7e5")
    public Call<NewsResponse> getNews();
}
