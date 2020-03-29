package com.example.mycompass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    Sensor accelermometer;
    TextView xValue,yValue,zValue,textA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);
        textA = (TextView) findViewById(R.id.textA);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelermometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(AccelerometerActivity.this, accelermometer, SensorManager.SENSOR_DELAY_NORMAL);



    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xValue.setText("X:" + event.values[0]);
        yValue.setText("Y:" + event.values[1]);
        zValue.setText("Z:" + event.values[2]);
        if(event.values[0] > 2){
            textA.setText("VÄNSTER");
        }
        if(event.values[0] < -2){
            textA.setText("HÖGER");
        }
        if(event.values[1] > 2){
            textA.setText("BAKÅT");
        }
        if(event.values[1] < -2){
            textA.setText("FRAMÅT");
        }
        if(event.values[2] > 11){
            textA.setText("NERÅT");
        }
        if(event.values[2] < 9){
            textA.setText("UPPÅT");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
