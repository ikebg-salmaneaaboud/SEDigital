package com.sedigital.gamr;

public class VideoGame {
    private String title;
    private String category;
    private double price;
    private int cover;

    public VideoGame(String title, String category, double price, int cover) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}
