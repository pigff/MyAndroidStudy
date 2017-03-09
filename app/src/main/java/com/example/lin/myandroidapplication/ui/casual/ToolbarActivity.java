package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_drawer_home);
        toolbar.setTitle("首页");
        toolbar.inflateMenu(R.menu.tool_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolbarActivity.this, "navigation", Toast.LENGTH_SHORT).show();
            }
        });
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.ic_notifications));
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuId = item.getItemId();
                switch (menuId) {
                    case R.id.action_search:
                        Toast.makeText(ToolbarActivity.this, "search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notification:
                        Toast.makeText(ToolbarActivity.this, "notify", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item1:
                        Toast.makeText(ToolbarActivity.this, "item1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_item2:
                        Toast.makeText(ToolbarActivity.this, "item2", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
