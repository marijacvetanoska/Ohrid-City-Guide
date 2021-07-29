package com.example.ohridcityguide.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ohridcityguide.database.dao.BlogPostDao;
import com.example.ohridcityguide.models.BlogPost;

@Database(entities = {BlogPost.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BlogPostDao blogPostDao();

    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null) {
            instance = create(context);
        }

        return instance;
    }

    private static AppDatabase create(final Context context){
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                "blogposts.db").build();
    }
}
