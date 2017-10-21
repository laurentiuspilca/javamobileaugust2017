package android.telacad.ro.jmc7e4;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telacad.ro.jmc7e4.model.LocationUser;
import android.telacad.ro.jmc7e4.service.UsersService;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListUsersActivity extends AppCompatActivity {

    private String username;
    private ListView listView;
    private ArrayAdapter<LocationUser> adapter;

    private UsersService service;
    private RegisterThread registerThread;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        username = getIntent().getStringExtra("username");
        listView = (ListView) findViewById(R.id.usersList);

        adapter = new ArrayAdapter<LocationUser>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LocationUser user = adapter.getItem(position);
                String geo = "geo:" + user.getLatitude() + "," + user.getLongitude();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geo));
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.5.1.0:5656")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(UsersService.class);
        Call<List<LocationUser>> call = service.users();
        call.enqueue(new Callback<List<LocationUser>>() {
            @Override
            public void onResponse(Call<List<LocationUser>> call, Response<List<LocationUser>> response) {
                adapter.clear();
                List<LocationUser> list = response.body();
                for (LocationUser u : list) {
                    adapter.add(u);
                }
            }

            @Override
            public void onFailure(Call<List<LocationUser>> call, Throwable t) {
                Log.e("LIST", t.getMessage(), t);
            }
        });

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new MyLocationListener());

        //latitude = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER).getLatitude();
        //latitude = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER).getLongitude();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerThread = new RegisterThread();
        registerThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (registerThread != null) {
            registerThread.interrupt();
            registerThread = null;
        }
    }

    private class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    private class RegisterThread extends Thread {

        public void run () {
            while (true) {
                try {
                    LocationUser user = new LocationUser();
                    user.setUsername(username);
                    user.setLatitude(latitude);
                    user.setLongitude(longitude);
                    Call<Void> call = service.register(user);
                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Log.i("REGISTER", "REGISTERED");
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Log.e("REGISTER", t.getMessage(), t);
                        }
                    });
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Log.e("RegisterThread", e.getMessage(), e);
                }
            }
        }
    }
}
