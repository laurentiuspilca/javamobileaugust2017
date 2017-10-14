package android.telacad.ro.jmc6e1.service;

import android.telacad.ro.jmc6e1.model.ExchangeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by student on 10/14/2017.
 */

public interface ExchangeCurrencyService {

    @GET("latest")
    public Call<ExchangeResponse> getCurrency();
}
