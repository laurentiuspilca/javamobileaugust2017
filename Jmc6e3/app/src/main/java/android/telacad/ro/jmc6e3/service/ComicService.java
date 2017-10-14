package android.telacad.ro.jmc6e3.service;

import android.telacad.ro.jmc6e3.model.ComicResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by student on 10/14/2017.
 */

public interface ComicService {
    @GET("{comic}/info.0.json")
    public Call<ComicResponse> getComic(@Path("comic") int comic);
}
