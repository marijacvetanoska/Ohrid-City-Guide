package com.example.ohridcityguide.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ohridcityguide.models.BlogPost;

import java.util.List;

@Dao
public interface BlogPostDao {
    @Query("SELECT * FROM blogposts")
    List<BlogPost> getAll();

    @Query("SELECT * FROM blogposts WHERE title LIKE :title LIMIT 1")
    BlogPost findByTitle(String title);

    @Insert
    void insertAll(BlogPost... posts);

    @Delete
    void delete(BlogPost blogPost);
}
