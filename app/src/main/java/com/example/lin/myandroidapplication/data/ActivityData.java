package com.example.lin.myandroidapplication.data;

/**
 * Created by lin on 2017/2/20.
 */
public class ActivityData {
    private String name;
    private String description;
    private Class<?> ClassName;
    private int type;

    public ActivityData(String name, String description, Class<?> contentClass) {
        this(name, description, contentClass, 0);
    }

    public ActivityData(String name, String description, Class<?> contentClass, int type) {
        this.name = name;
        this.description = description;
        this.ClassName = contentClass;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class<?> getClassName() {
        return ClassName;
    }
}
