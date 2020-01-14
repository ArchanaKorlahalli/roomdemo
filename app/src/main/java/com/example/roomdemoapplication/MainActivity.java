package com.example.roomdemoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdemoapplication.adapter.UserAdapter;
import com.example.roomdemoapplication.database.AppDatabase;
import com.example.roomdemoapplication.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText, mEmailIdEditText, mPhoneNoEditText;
    private Button mAddButton, mUpdateButton;
    private RecyclerView mUserListRecyclerView;
    private AppDatabase mAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initValues();
    }

    private void initValues() {
        mNameEditText = findViewById(R.id.et_name);
        mEmailIdEditText = findViewById(R.id.et_emailId);
        mPhoneNoEditText = findViewById(R.id.et_phoneNo);
        mAddButton = findViewById(R.id.bt_add);
        mUpdateButton = findViewById(R.id.bt_update);
        mUserListRecyclerView = findViewById(R.id.rv_userList);
        mAppDatabase = AppDatabase.getAppDatabase(getApplicationContext());
        //setList();
        setValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setList();

    }

    private void setList() {
        List<User> userDataList = mAppDatabase.userDao().getAllUsers();
        setMyAdapter(userDataList);
    }

    private void setValues() {
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString().trim();
                String emailId = mEmailIdEditText.getText().toString().trim();
                String phoneNo = mPhoneNoEditText.getText().toString().trim();

                if (name.isEmpty())
                    name = "Archana";
                if (emailId.isEmpty())
                    emailId = "archanakorlahalli2@gmail.com";
                if (phoneNo.isEmpty())
                    phoneNo = "8951046011";

                User user = new User(name, emailId, phoneNo);
                mAppDatabase.userDao().insertUser(user);
                Toast.makeText(MainActivity.this, "Values Inserted", Toast.LENGTH_SHORT).show();

                mNameEditText.setText("");
                mEmailIdEditText.setText("");
                mPhoneNoEditText.setText("");

                setList();
            }
        });

        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

//        mUpdateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = mNameEditText.getText().toString().trim();
//                String emailId = mEmailIdEditText.getText().toString().trim();
//                String phoneNo = mPhoneNoEditText.getText().toString().trim();
//
//                if (name.isEmpty())
//                    Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
//
//                else if (emailId.isEmpty())
//                    Toast.makeText(MainActivity.this, "Enter Email ID", Toast.LENGTH_SHORT).show();
//
//                else if (phoneNo.isEmpty())
//                    Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
//
//                else {
//                    mAppDatabase.userDao().updateUser(emailId, phoneNo, name);
//                    Toast.makeText(MainActivity.this, "Values Updated", Toast.LENGTH_SHORT).show();
//
//                    mNameEditText.setText("");
//                    mEmailIdEditText.setText("");
//                    mPhoneNoEditText.setText("");
//
//                    setList();
//                }
//
//            }
//        });
    }

    private void setMyAdapter(List<User> userDataList) {
        UserAdapter userAdapter = new UserAdapter(MainActivity.this, userDataList);
        mUserListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mUserListRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mUserListRecyclerView.setAdapter(userAdapter);
    }
}
