package com.example.lin.myandroidapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by lin on 2016/10/26.
 */
public class TextViewStudy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview_layout);
        init();
    }

    private void init() {
        TextView textView = (TextView) findViewById(R.id.superLinkText);
        String content = "<font color='blue'><b>百度一下，你就知道~：</b></font><br>" + "<a href = 'http://www.baidu.com'>百度</a>";
        textView.setText(Html.fromHtml(content));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
