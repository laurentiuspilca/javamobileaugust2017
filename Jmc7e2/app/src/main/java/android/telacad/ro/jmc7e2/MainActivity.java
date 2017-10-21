package android.telacad.ro.jmc7e2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ALL);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        for (Sensor s : sensorList) {
            adapter.add(s.getName() + " " + s.getVendor() );
        }

        Sensor sensor = manager.getDefaultSensor(Sensor.TYPE_GRAVITY);

        manager.registerListener(new MySenstorListener(), sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }


    private class MySenstorListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            //Toast.makeText(MainActivity.this, "X: " + x + " Y:" + y + " Z:" +z, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    }
}
