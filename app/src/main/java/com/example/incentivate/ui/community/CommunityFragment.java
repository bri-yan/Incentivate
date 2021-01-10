package com.example.incentivate.ui.community;

import android.content.Intent;
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

import com.example.incentivate.R;
import com.example.incentivate.ui.dashboard.DashboardViewModel;
import com.example.incentivate.ui.dashboard.RecyclerAdapter;

public class CommunityFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_community, container, false);
        ImageView prize = (ImageView) root.findViewById(R.id.community_app_bar_image);
        int imageResource = getResources().getIdentifier("@drawable/banner", null, getActivity().getPackageName());
        prize.setImageResource(imageResource);

        recyclerView = root.findViewById(R.id.leaderboard_recycler);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LeaderboardAdapter();
        recyclerView.setAdapter(adapter);
        return root;
    }



}