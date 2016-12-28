package com.example.lin.myandroidapplication.bean;

/**
 * Created by lin on 2016/12/27.
 */
public class VpBean {

    private int imgSrc;
    private String name;

    public VpBean(int imgSrc, String name) {
        this.imgSrc = imgSrc;
        this.name = name;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
