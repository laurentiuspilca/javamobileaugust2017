package android.telacad.ro.jmc7e4.service;

import android.telacad.ro.jmc7e4.model.LocationUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by student on 10/21/2017.
 */

public interface UsersService {

    @GET("list")
    Call<List<LocationUser>> users();

    @POST("register")
    Call<Void> register(@Body LocationUser user);
}
