package divyanshu.aclaglid.in.aclagliddemos.Sensors;

import android.app.Activity;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.widget.TextView;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 10/06/16.
 */
public class SensorActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    TextView xCoor;
    TextView yCoor;
    TextView zCoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        xCoor = (TextView)findViewById(R.id.xcoor);
        yCoor = (TextView)findViewById(R.id.ycoor);
        zCoor = (TextView)findViewById(R.id.zCoor);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];


            xCoor.setText("X "+ x);
            yCoor.setText("Y "+ y);
            zCoor.setText("Z "+ z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
