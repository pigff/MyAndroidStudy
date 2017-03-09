package com.example.lin.myandroidapplication.ui.pig;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.adapter.CommonAdapter;
import com.example.lin.myandroidapplication.data.Book;
import com.example.lin.myandroidapplication.data.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lin on 2016/11/2.
 */
public class ListViewStudy extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_layout);
        ListView listView = (ListView) findViewById(R.id.lv_01);
        ListView listView1 = (ListView) findViewById(R.id.lv_02);
        List<Book> books = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book("第一行代码", "郭霖");
            books.add(book);
        }
        for (int i = 0; i < 10; i++) {
            Student student = new Student("小王", 14);
            students.add(student);
        }

        CommonAdapter<Book> adapter = new CommonAdapter<Book>(books, R.layout.lv_item) {
            @Override
            public void bindView(ViewHolder holder, Book obj) {
                holder.setText(R.id.left_item, obj.getName())
                .setText(R.id.right_item, obj.getAuthor());
            }
        };
        listView.setAdapter(adapter);
        CommonAdapter<Student> adapter1 = new CommonAdapter<Student>(students, R.layout.lv_item) {
            @Override
            public void bindView(ViewHolder holder, Student obj) {
                holder.setText(R.id.left_item, obj.getName());
                holder.setText(R.id.right_item, String.valueOf(obj.getAge()));
            }
        };
        listView1.setAdapter(adapter1);
    }
}
