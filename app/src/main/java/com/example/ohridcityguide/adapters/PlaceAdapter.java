package com.example.ohridcityguide.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ohridcityguide.R;
import com.example.ohridcityguide.models.BlogPost;
import com.example.ohridcityguide.models.Place;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>{
    private List<Place> places;
    private PlaceAdapter.PlaceClickListener placeClickListener;

    public PlaceAdapter(List<Place> places) {
        this.places = places;
    }

    @NonNull
    @Override
    public PlaceAdapter.PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sights, null, false);
        return new PlaceAdapter.PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.PlaceViewHolder holder, int position) {
        holder.bindData(places.get(position), placeClickListener);
    }

    @Override
    public int getItemCount() {
        if(places == null)
            return 0;
        return places.size();
    }

    static class PlaceViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;
        private TextView tvDescription;
        private ImageView ivImage;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            ivImage = (ImageView) itemView.findViewById(R.id.imImage);
        }

        public void bindData(Place place, final PlaceAdapter.PlaceClickListener listener) {
            tvName.setText(place.getName());
            tvDescription.setText(place.getShortDesc());
            Glide.with(itemView).load(place.getImageId()).into(ivImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPlaceClicked(place.getName());
                }
            });
        }
    }

    public interface PlaceClickListener{
        void onPlaceClicked(String name);
    }

    public void setPlaceClickListener(PlaceAdapter.PlaceClickListener placeClickListener) {
        this.placeClickListener = placeClickListener;
    }

}

