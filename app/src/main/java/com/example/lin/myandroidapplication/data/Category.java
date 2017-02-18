package com.example.lin.myandroidapplication.data;

/**
 * Created by lin on 2016/12/12.
 */
public class Category {

    private int imgSrc;

    private String category;

    public Category(int imgSrc, String category) {
        this.imgSrc = imgSrc;
        this.category = category;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "imgSrc=" + imgSrc +
                ", category='" + category + '\'' +
                '}';
    }
}
