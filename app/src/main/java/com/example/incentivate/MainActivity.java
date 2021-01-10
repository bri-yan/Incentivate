package com.example.incentivate;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.incentivate.ui.PedometerSensorService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

/*    private Intent pedometerServiceIntent;
    private PedometerSensorService pedometerSensorService;*/
    private TextView stepsToday;

    private SensorManager sensorManager;
    boolean running = false;
    private int totalStepsToday;
    Sensor stepSensor;
    private TextView stepToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
        FloatingActionButton button = findViewById(R.id.goToAddGoal);
        button.setOnClickListener(this::launchAddGoalActivity);

        stepToday = findViewById(R.id.steps_taken_today);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepToday.setText("6");
        //startCounter();
    }

    public void launchAddGoalActivity(View v) {
        Intent i = new Intent(this, AddGoalActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(stepSensor != null){
            sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI);
        }else{
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        running = false;
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d("Steps","I'm happy");
        if(running){
            stepToday.setText(String.valueOf(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}