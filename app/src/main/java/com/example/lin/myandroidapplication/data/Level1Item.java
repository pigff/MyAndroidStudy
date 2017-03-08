package com.example.lin.myandroidapplication.data;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.lin.myandroidapplication.adapter.ExpandMultiAdapter;

/**
 * Created by lin on 2017/3/8.
 */

public class Level1Item extends AbstractExpandableItem<Person> implements MultiItemEntity{

    private String title;

    public Level1Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getItemType() {
        return ExpandMultiAdapter.TYPE_LEVEL_1;
    }
}
