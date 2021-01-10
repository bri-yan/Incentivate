package com.example.incentivate.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incentivate.Goal;
import com.example.incentivate.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    ImageView workoutIcon;
    TextView noGoals;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        workoutIcon = root.findViewById(R.id.workout_icon);
        noGoals = root.findViewById(R.id.no_goals);

/*        if(Goal.goals==null||Goal.goals.size()<=0){
            workoutIcon.setVisibility(View.VISIBLE);
            noGoals.setVisibility(View.VISIBLE);
        }else{
            workoutIcon.setVisibility(View.INVISIBLE);
            noGoals.setVisibility(View.INVISIBLE);
        }*/

        recyclerView = root.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        return root;
    }



}