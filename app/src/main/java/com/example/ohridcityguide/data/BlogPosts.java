package com.example.ohridcityguide.data;

import com.example.ohridcityguide.R;
import com.example.ohridcityguide.models.Article;
import com.example.ohridcityguide.models.BlogPost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BlogPosts {
    private HashMap<String, Article> posts;

    public BlogPosts() {
        posts = initData();
    }

    public HashMap<String, Article> getPosts() {
        return posts;
    }

    private HashMap<String, Article> initData() {
        HashMap<String, Article> posts = new HashMap<>();
        Article a1 = new Article(1, "The Best Things to do in Ohrid, North Macedonia", "https://theculturetrip.com/europe/macedonia/articles/the-best-things-to-do-in-ohrid-north-macedonia/", R.drawable.a1);
        Article a2 = new Article(2, "ARCHITECTURE AND ART PRIOR TO THE XX CENTURY – HISTORY OF OHRID", "https://vmacedonia.com/travel/cities/ohrid/architecture-art-prior-xx-century.html", R.drawable.a2);
        Article a3 = new Article(3, "Nightlife in Ohrid", "https://www.lonelyplanet.com/macedonia/southern-macedonia/ohrid/nightlife", R.drawable.a3);
        Article a4 = new Article(4, "Ohrid-the city that had 365 churches, one for each day of the year", "https://www.thevintagenews.com/2016/11/22/ohrid-the-city-that-had-365-churches-one-for-each-day-of-the-year/", R.drawable.a4);
        Article a5 = new Article(5, "Best restaurants in Ohrid", "https://www.lonelyplanet.com/macedonia/southern-macedonia/ohrid/restaurants", R.drawable.a5);
        Article a6 = new Article(6, "Best Beaches in Ohrid", "https://www.discoveringmacedonia.com/2019/best-beaches-in-ohrid/", R.drawable.a6);

        posts.put("The Best Things to do in Ohrid, North Macedonia", a1);
        posts.put("ARCHITECTURE AND ART PRIOR TO THE XX CENTURY – HISTORY OF OHRID", a2);
        posts.put("Nightlife in Ohrid", a3);
        posts.put("Ohrid-the city that had 365 churches, one for each day of the year", a4);
        posts.put("Best restaurants in Ohrid", a5);
        posts.put("Best Beaches in Ohrid", a6);
        return posts;
    }
}
