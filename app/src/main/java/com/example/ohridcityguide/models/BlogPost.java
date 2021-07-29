package com.example.ohridcityguide.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "blogposts")
public class BlogPost {
    @PrimaryKey
    private int id;
    private String title;
    private String content;
    private String imageUrl;

    public BlogPost() {
    }

    public BlogPost(int id, String title, String content, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
