package com.example.incentivate.ui.community;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.incentivate.R;

public class ExerciseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        View walkCard = findViewById(R.id.walk_card);
        walkCard.setOnClickListener(this::goWalking);
    }

    public void goWalking(View view){
            /*Intent intent = new Intent(this, WalkModule.class);
            startActivity(intent);*/
    }
}