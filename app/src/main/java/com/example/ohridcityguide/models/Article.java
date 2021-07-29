package com.example.ohridcityguide.models;

public class Article {
    private int id;
    private String title;
    private String url;
    private int imageId;

    public Article(int id, String title, String url, int imageId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
