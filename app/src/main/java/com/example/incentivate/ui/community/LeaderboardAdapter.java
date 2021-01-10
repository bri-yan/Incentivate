package com.example.incentivate.ui.community;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incentivate.R;
import com.google.android.material.snackbar.Snackbar;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>{
    private String[] goals = {
            "Friend One",
            "Friend Two",
            "Friend Three",
            "Friend Four",
            "Friend Five",
            "Friend Six",
            "Friend Seven",
            "Friend Eight"};

    private String[] details = {"Item one details",
            "Item two details", "Item three details",
            "Item four details", "Item file details",
            "Item six details", "Item seven details",
            "Item eight details"};

    private int[] images = {
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24,
            R.drawable.ic_baseline_face_24};

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        CardView cardView;
        public ImageView itemImage;
        public TextView itemTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.community_image);
            itemTitle = (TextView)itemView.findViewById(R.id.community_name);
            cardView = (CardView) itemView;

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
    public LeaderboardAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.community_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LeaderboardAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(goals[i]);
        viewHolder.itemImage.setImageResource(R.drawable.ic_baseline_face_24);
        if (i==0){
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#D7BE69"));
        }else if (i==1){
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#D8D8D8"));
        }else if (i==2){
            viewHolder.cardView.setCardBackgroundColor(Color.parseColor("#A97142"));
        }
    }

    @Override
    public int getItemCount() {
        return goals.length;
    }
}
