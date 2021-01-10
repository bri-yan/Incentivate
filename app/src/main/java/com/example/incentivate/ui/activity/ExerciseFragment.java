package com.example.incentivate.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.incentivate.R;

public class ExerciseFragment extends Fragment implements View.OnClickListener {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        final TextView textView = root.findViewById(R.id.activities_title);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button newBlockButton = (Button) getActivity().findViewById(
                R.id.new_exercise_button);
        newBlockButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), ExerciseList.class);
        startActivity(intent);
    }
}