package com.example.incentivate.ui.home;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.incentivate.CreateAccountActivity;
import com.example.incentivate.R;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {


    private int stepProgressStatus = 0;
    private TextView mGoalText;
    private HomeViewModel homeViewModel;
    TextView name, status;
    TextView goal;
    BarChart stepChart;
    private ProgressBar stepBar;

    private Handler stepHandler = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        String userName = mPreferences.getString(getString(R.string.name),"");
        System.out.println("Name: " + userName);
        User user = new User(userName);

        name = (TextView)root.findViewById(R.id.user_Name);
        status = root.findViewById(R.id.status);
        goal = root.findViewById(R.id.user_Goal);

        name.setText(user.getName());

        goal.setText("Goal: 10,000 steps every day for 1 month!");


        //Progress Bar

        stepBar = (ProgressBar) root.findViewById(R.id.stepProgressBar);
        stepBar.setProgress(stepProgressStatus);

        //Bar graph
        float barWidth = 0.3f;
        float barSpace = 0.2f;
        float groupSpace = 0.4f;

        stepChart = (BarChart) root.findViewById(R.id.bargraph);

        stepChart.setDescription(null);
        stepChart.setPinchZoom(false);
        stepChart.setScaleEnabled(false);
        stepChart.setDrawBarShadow(false);
        stepChart.setDrawGridBackground(false);

        int groupCount = 6;


        ArrayList<BarEntry> stepEntries = new ArrayList<>();

        stepEntries.add(new BarEntry(1,(float)8135));
        stepEntries.add(new BarEntry(2,(float)3423));
        stepEntries.add(new BarEntry(3,(float)9123));
        stepEntries.add(new BarEntry(4,(float)2647));
        stepEntries.add(new BarEntry(5,(float)2374));
        stepEntries.add(new BarEntry(6,(float)3647));
        stepEntries.add(new BarEntry(7,(float)1245));


        BarDataSet stepSet= new BarDataSet(stepEntries, "Dates");

        LocalDate day1 = LocalDate.now();
        LocalDate day2 = day1.minusDays(1);
        LocalDate day3 = day1.minusDays(2);
        LocalDate day4 = day1.minusDays(3);
        LocalDate day5 = day1.minusDays(4);
        LocalDate day6 = day1.minusDays(5);
        LocalDate day7 = day1.minusDays(6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE");

        ArrayList<String> dates = new ArrayList<>();
        dates.add(day1.format(formatter));
        dates.add(day2.format(formatter));
        dates.add(day3.format(formatter));
        dates.add(day4.format(formatter));
        dates.add(day5.format(formatter));
        dates.add(day6.format(formatter));
        dates.add(day7.format(formatter));

        ArrayList<IBarDataSet> stepSets = new ArrayList<>();
        stepSets.add(stepSet);

        BarData stepData = new BarData(stepSets);

        stepData.setValueFormatter(new LargeValueFormatter());

        stepChart.setData(stepData);

        /*
        stepChart.getBarData().setBarWidth(barWidth);
        stepChart.getXAxis().setAxisMinimum(0);
        stepChart.getXAxis().setAxisMaximum(0 + stepChart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        stepChart.groupBars(0, groupSpace, barSpace);
        stepChart.getData().setHighlightEnabled(false);
        stepChart.invalidate();

         */


        //X-axis
        XAxis xAxis = stepChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(6);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(dates));

        /*
        //Y-axis
        stepChart.getAxisRight().setEnabled(false);
        YAxis leftAxis = stepChart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);

         */





        return root;
    }

}