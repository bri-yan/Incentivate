package com.example.incentivate.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.incentivate.R;

public class PedometerSensorService extends Service implements SensorEventListener {
    private SensorManager sensorManager;
    private int totalStepsToday;
    private int nSteps;
    Sensor stepSensor;
    private Context ctx;
    private TextView stepDisplay = null;

    public PedometerSensorService(Context ctx, TextView stepDisplay){
        super();
        Log.d("Pedometer","Pedometer Started");
        this.ctx = ctx;
        this.stepDisplay = stepDisplay;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        startCounter();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("EXIT", "ondestroy!");
        Intent broadcastIntent = new Intent(this, PedometerRestarterBroadcastReceiver.class);

        sendBroadcast(broadcastIntent);
        stop();
    }

    public void resume(){
        sensorManager.registerListener((SensorEventListener) ctx,stepSensor,SensorManager.SENSOR_DELAY_UI);
    }

    public void stop(){
        sensorManager.unregisterListener((SensorEventListener) ctx, stepSensor);
        saveSteps();
        totalStepsToday = 0;
    }

    public void startCounter(){
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //loadSteps();
        Log.d("Pedometer", "Looking for sensor");
        if(stepSensor == null){
            Toast.makeText(ctx, "No step sensor detected", Toast.LENGTH_SHORT).show();
            Log.d("Pedometer", "Looking for sensor y");
        }else{
            sensorManager.registerListener((SensorEventListener) ctx,stepSensor,SensorManager.SENSOR_DELAY_UI);
            Log.d("Pedometer", "Looking for sensor n");
        }
    }

    private void saveSteps(){
        SharedPreferences sharedPreferences = getSharedPreferences("incentivate", Context.MODE_PRIVATE);
        SharedPreferences.Editor spe = sharedPreferences.edit();
        spe.putInt("StepsToday",totalStepsToday + sharedPreferences.getInt("StepsToday", 0));
        spe.apply();
    }

    private void loadSteps(){
        SharedPreferences sharedPreferences = getSharedPreferences("incentivate", Context.MODE_PRIVATE);
        totalStepsToday = sharedPreferences.getInt("StepsToday", 0);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        totalStepsToday = (int) event.values[0];
        System.out.println(totalStepsToday);
        //int currentSteps = totalStepsToday - nSteps;
        if(stepDisplay!=null){
            stepDisplay.setText(Integer.toString(totalStepsToday));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
