package com.example.lin.myandroidapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView htmlText = (TextView) findViewById(R.id.superLinkText);
        String content = "<font color='blue'><b>百度一下，你就知道~：</b></font><br>" + "<a href = 'http://www.baidu.com'>百度</a>";
        htmlText.setText(Html.fromHtml(content));
        htmlText.setMovementMethod(LinkMovementMethod.getInstance());

        TextView spanText = (TextView) findViewById(R.id.span_text);
        SpannableString spannableString = new SpannableString("红色打电话斜体删除线绿色下划线图片");
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new URLSpan("tel:1212121"), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(Typeface.ITALIC), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StrikethroughSpan(), 7, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 10, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.GREEN), 10, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Drawable drawable = getResources().getDrawable(R.drawable.text_img);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        spannableString.setSpan(imageSpan, 15, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanText.setText(spannableString);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append("好友" + i + ",");
        }
        String likeUsers = stringBuilder.substring(0, stringBuilder.lastIndexOf(",")).toString();
        TextView spanStringBuilderText = (TextView) findViewById(R.id.spanStringBuilderText);
        spanStringBuilderText.setMovementMethod(LinkMovementMethod.getInstance());
        spanStringBuilderText.setText(addClickPart(likeUsers), TextView.BufferType.SPANNABLE);
    }

    private SpannableStringBuilder addClickPart(String str) {
        ImageSpan imageSpan = new ImageSpan(this, R.drawable.text_img);
        SpannableString spanStr = new SpannableString("p.");
        spanStr.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
        ssb.append(str);
        String[] likeUsers = str.split(",");
        if (likeUsers.length > 0) {
            for (int i = 0; i < likeUsers.length; i++) {
                final String name = likeUsers[i];
                int start = str.indexOf(name) + spanStr.length();
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(TextViewStudy.this, name, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                    }
                }, start, start + name.length(), 0);
            }
        }
        return ssb.append("等" + likeUsers.length + "个人觉得很赞");
    }
}
