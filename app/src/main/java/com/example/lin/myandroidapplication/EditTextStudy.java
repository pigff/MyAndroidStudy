package com.example.lin.myandroidapplication;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lin on 2016/10/26.
 */
public class EditTextStudy extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_layout);
        init();
    }

    private void init() {
        final EditText editText = (EditText) findViewById(R.id.emoji_edit);
        Button button = (Button) findViewById(R.id.add_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableString spannableString = new SpannableString("image");
                Drawable drawable = getResources().getDrawable(R.drawable.ic_mood);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                spannableString.setSpan(span, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                int cursor = editText.getSelectionStart();
                editText.getText().insert(cursor, spannableString);
            }
        });
    }
}
