package com.example.lin.myandroidapplication.ui.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/10/26.
 */
public class EditTextStudy extends Activity {

    private TextInputLayout mInputEditText;
    private EditText mMdEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext_layout);
        init();
    }

    private void init() {
        final EditText editText = (EditText) findViewById(R.id.emoji_edit);
        mInputEditText = (TextInputLayout) findViewById(R.id.edit_layout);
        mMdEdit = (EditText) findViewById(R.id.md_edit);
        mMdEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = String.valueOf(mMdEdit.getText());
                if (!TextUtils.equals(string, "ok")) {
                    mInputEditText.setErrorEnabled(true);
                    mInputEditText.setError("错啦错啦");
                    mInputEditText.requestFocus();
                }
            }
        });
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
