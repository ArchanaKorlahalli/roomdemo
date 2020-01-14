package com.example.roomdemoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    private EditText mNameEditTextUpdate, mEmailIdEditTextUpdate, mPhoneNoEditTextUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
    }

    private void initView() {
        mNameEditTextUpdate= findViewById(R.id.et_name_update);
    }
}
