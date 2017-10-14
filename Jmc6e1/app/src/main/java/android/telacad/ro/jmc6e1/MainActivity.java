package android.telacad.ro.jmc6e1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc6e1.model.ExchangeResponse;
import android.telacad.ro.jmc6e1.service.ExchangeCurrencyService;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ExchangeCurrencyService service;

    private EditText txtEur;
    private Button btnConvert;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEur = (EditText) findViewById(R.id.etEur);
        tvResult = (TextView) findViewById(R.id.convertionResult);
        btnConvert = (Button) findViewById(R.id.btnConvert);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fixer.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ExchangeCurrencyService.class);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int eur = Integer.parseInt(txtEur.getText().toString());
                convert(eur);
            }
        });
    }

    private void convert(final int eur) {
        service.getCurrency().enqueue(new Callback<ExchangeResponse>() {
            @Override
            public void onResponse(Call<ExchangeResponse> call, Response<ExchangeResponse> response) {
                ExchangeResponse er = response.body();
                double rate = er.getRates().get("RON");
                Log.i("MAIN", eur + " EUR = " + (eur * rate));
                tvResult.setText((eur*rate) + " RON");
            }

            @Override
            public void onFailure(Call<ExchangeResponse> call, Throwable t) {
                Log.e("MAIN", "ERROR", t);
            }
        });
    }
}
