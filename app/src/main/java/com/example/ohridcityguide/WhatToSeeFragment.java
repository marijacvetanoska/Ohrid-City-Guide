package com.example.ohridcityguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ohridcityguide.adapters.PlaceAdapter;
import com.example.ohridcityguide.data.PlacesToSee;
import com.example.ohridcityguide.models.BlogPost;
import com.example.ohridcityguide.models.Place;

import java.util.List;

public class WhatToSeeFragment extends Fragment {

    private RecyclerView placesList;
    private PlaceAdapter placeAdapter;
    private PlacesToSee placesToSee = new PlacesToSee();
    private List<Place> list;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_what_to_see, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = placesToSee.getPlaces();

        placesList = (RecyclerView) view.findViewById(R.id.placesList);
        placeAdapter = new PlaceAdapter(list);

        placeAdapter.setPlaceClickListener(new PlaceAdapter.PlaceClickListener() {
            @Override
            public void onPlaceClicked(String name) {
                PlaceMapFragment fragment = PlaceMapFragment.newInstance(
                        placesToSee.findByName(name).getLat(),
                        placesToSee.findByName(name).getLon());
                openFragment(fragment);
            }
        });

        placesList.setAdapter(placeAdapter);
    }

    private void openFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }
}