package com.example.lin.myandroidapplication.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by lin on 2016/12/12.
 */
public class Multi implements MultiItemEntity {

    public static final int IMAGE = 0;
    public static final int CATEGORY = 1;
    public static final int HORIZION = 2;

    private int itemType;

    private List<Category> categories;
    private int imgSrc;

    public Multi(int itemType, int imgSrc) {
        this.itemType = itemType;
        this.imgSrc = imgSrc;
    }

    public Multi(int itemType, List<Category> categories) {
        this.itemType = itemType;
        this.categories = categories;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public List<Category> getCategory() {
        return categories;
    }

    public void setCategory(List<Category> categories) {
        this.categories = categories;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
