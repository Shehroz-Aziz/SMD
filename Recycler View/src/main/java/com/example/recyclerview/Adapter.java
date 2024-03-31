package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<Restaurant> restaurants;
    public Adapter(ArrayList<Restaurant> list)
    {
        restaurants = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.single_chat_item, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvRestaurantName.setText(restaurants.get(position).getName());
        holder.tvLocation.setText(restaurants.get(position).getLocation());
        holder.tvContact.setText(restaurants.get(position).getContact());
        holder.tvRatings.setText(restaurants.get(position).getRatings());
        holder.tvDescription.setText(restaurants.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvDescription, tvRestaurantName, tvLocation, tvRatings, tvContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvContact = itemView.findViewById(R.id.tvContact);
            tvRestaurantName = itemView.findViewById(R.id.tvRestaurantName);
            tvRatings = itemView.findViewById(R.id.tvRatings);
            tvLocation = itemView.findViewById(R.id.tvLocation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), tvContact.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
