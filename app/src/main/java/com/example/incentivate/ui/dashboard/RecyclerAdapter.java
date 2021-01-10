package com.example.incentivate.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incentivate.Goal;
import com.example.incentivate.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] titles = {"Goal One",
            "Goal Two",
            "Goal Three",
            "Goal Four",
            "Goal Five",
            "Goal Six",
            "Goal Seven",
            "Goal Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = { R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp};

    private List<Goal> goals;

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView, Goal goal) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        goals = Goal.goals;
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.goal_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v, goals.get(i));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        /*viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);*/
        goals = Goal.goals;
        Goal goal = goals.get(i);
        viewHolder.itemTitle.setText(goal.title);
        viewHolder.itemDetail.setText(String.valueOf(goal.goalAmount));

        viewHolder.itemImage.setImageResource(R.drawable.ic_baseline_fitness_center_24);
    }

    @Override
    public int getItemCount() {
        goals = Goal.goals;
        if(goals==null||goals.isEmpty()){
            return 0;
        }else{
            return goals.size();
        }
    }
}
