package com.example.lin.myandroidapplication.bean;

/**
 * Created by lin on 2016/11/4.
 */
public class Role {

    private String icon;

    private String name;

    public Role(String icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
