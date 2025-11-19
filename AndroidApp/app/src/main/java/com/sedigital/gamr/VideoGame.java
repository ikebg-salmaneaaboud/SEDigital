package com.sedigital.gamr;

import java.util.ArrayList;

public class VideoGame {
    private String title;
    private String category;
    private double price;
    private String developer;
    private double rating;
    private String description;
    private int cover;
    private ArrayList<Integer> images;

    public VideoGame(String title, String category, double price, String developer,
                     double rating, String description, int cover, ArrayList<Integer> images) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.developer = developer;
        this.rating = rating;
        this.description = description;
        this.cover = cover;
        this.images = images;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getDeveloper() { return developer; }
    public double getRating() { return rating; }
    public String getDescription() { return description; }
    public int getCover() { return cover; }
    public ArrayList<Integer> getImages() { return images; }
}
