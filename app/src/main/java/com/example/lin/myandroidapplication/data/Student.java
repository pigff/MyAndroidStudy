package com.example.lin.myandroidapplication.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.lin.myandroidapplication.adapter.ExpandMultiAdapter;

/**
 * Created by lin on 2016/11/2.
 */
public class Student implements MultiItemEntity {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getItemType() {
        return ExpandMultiAdapter.TYPE_STUDENT;
    }
}
