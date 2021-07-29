package com.example.ohridcityguide.data;

import com.example.ohridcityguide.R;
import com.example.ohridcityguide.models.Place;

import java.util.ArrayList;
import java.util.List;

public class PlacesToSee {
    private List<Place> places;

    public PlacesToSee() {
        places = initData();
    }

    public List<Place> getPlaces() {
        return places;
    }

    private List<Place> initData() {
        places = new ArrayList<>();

        places.add(new Place("St. John the Theologian", R.drawable.svjovankaneo, "Grand historic church with lake views", Double.parseDouble("41.112484504641806"), Double.parseDouble("20.7888287647522")));
        places.add(new Place("Samoil's Fortress", R.drawable.samoilova, "Imposing Byzantine era city wall ruins", Double.parseDouble("41.116239655315105"), Double.parseDouble("20.79079624421936")));
        places.add(new Place("Saint Sophia", R.drawable.svsofija, "Ancient, art-filled landmark church", Double.parseDouble("41.11278097171521"), Double.parseDouble("20.79427212461135")));
        places.add(new Place("Ancient theatre of Ohrid", R.drawable.antickiteatar, "Ancient amphitheater & performance venue", Double.parseDouble("41.11599261252981"), Double.parseDouble("20.79361629812229")));
        places.add(new Place("Church of Saints Clement and Panteleimon - Plaoshnik", R.drawable.plaosnik, "Ancient hillside church overlooking lake and Archeological & religious site", Double.parseDouble("41.11347272301339"), Double.parseDouble("20.790861826868266")));

        return places;
    }

    public Place findByName(String name) {
        for (Place p : places) {
            if(p.getName().equals(name))
                return p;
        }
        return new Place("", 0, "", 0, 0);
    }
}
