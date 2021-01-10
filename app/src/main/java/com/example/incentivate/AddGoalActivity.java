package com.example.incentivate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.incentivate.ui.datetime.DateFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddGoalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Calendar startDate;
    Calendar endDate;
    Calendar startTime;
    Calendar endTime;
    EditText activityName;
    EditText startDateText;
    EditText endDateText;
    EditText startTimeText;
    EditText endTimeText;
    EditText goalText;
    EditText depositText;
    EditText notesText;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        activityName = findViewById(R.id.activityName);



        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button button = findViewById(R.id.submitButton);
        button.setOnClickListener(this::goHome);

        startDateText = findViewById(R.id.dateText);
        startDateText.setShowSoftInputOnFocus(false);
        startDateText.setOnClickListener(this::showStartDatePickerDialog);

        endDateText = findViewById(R.id.dateText2);
        endDateText.setShowSoftInputOnFocus(false);
        endDateText.setOnClickListener(this::showEndDatePickerDialog);

        startTimeText = findViewById(R.id.timeText);
        startTimeText.setShowSoftInputOnFocus(false);
        startTimeText.setOnClickListener(this::showStartTimePickerDialog);

        endTimeText = findViewById(R.id.timeText1);
        endTimeText.setShowSoftInputOnFocus(false);
        endTimeText.setOnClickListener(this::showEndTimePickerDialog);

        goalText = findViewById(R.id.goal);
        depositText = findViewById(R.id.deposit);
        notesText = findViewById(R.id.notes);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void goHome(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        String title = activityName.getText().toString();
        int goalAmount = Integer.parseInt(goalText.getText().toString());
        double deposit = Double.parseDouble(depositText.getText().toString());
        String notes = notesText.getText().toString();

        Goal goal = new Goal(title, startDate, startTime, endDate, endTime, goalAmount, deposit, notes);
        System.out.println(Goal.goals.get(0));
    }

    public void showStartDatePickerDialog(View v) {
        DialogFragment newFragment = new DateFragment();
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        DatePickerDialog picker = new DatePickerDialog(AddGoalActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar c = Calendar.getInstance();
                        c.set(year, monthOfYear, dayOfMonth);
                        startDateText.setText(new SimpleDateFormat("MMM. DD").format(c.getTime()));
                        startDate = c;
                    }
                }, year, month, day);
        picker.show();
    }

    public void showEndDatePickerDialog(View v) {
        DialogFragment newFragment = new DateFragment();
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        DatePickerDialog picker = new DatePickerDialog(AddGoalActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar c = Calendar.getInstance();
                        c.set(year, monthOfYear, dayOfMonth);
                        endDateText.setText(new SimpleDateFormat("MMM. DD").format(c.getTime()));
                        endDate = c;
                    }
                }, year, month, day);
        picker.show();
    }

    public void showStartTimePickerDialog(View v) {
        DialogFragment newFragment = new DateFragment();
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        int hour = cldr.get(Calendar.HOUR_OF_DAY);
        int minute = cldr.get(Calendar.MINUTE);
        TimePickerDialog picker = new TimePickerDialog(AddGoalActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(year, month, day, hourOfDay, minute);
                        startTimeText.setText(new SimpleDateFormat("h:mm aa").format(c.getTime()));
                        startTime = c;
                    }
                }, hour, minute, false);
        picker.show();
    }

    public void showEndTimePickerDialog(View v) {
        DialogFragment newFragment = new DateFragment();
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        int hour = cldr.get(Calendar.HOUR_OF_DAY);
        int minute = cldr.get(Calendar.MINUTE);
        TimePickerDialog picker = new TimePickerDialog(AddGoalActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(year, month, day, hourOfDay, minute);
                        endTimeText.setText(new SimpleDateFormat("h:mm aa").format(c.getTime()));
                        endTime = c;
                    }
                }, hour, minute, false);
        picker.show();
    }
}