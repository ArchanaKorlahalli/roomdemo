package com.example.roomdemoapplication.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdemoapplication.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView mNameTextView, mEmailIdTextView, mPhoneNoTextView;
    public LinearLayout mUserListLayout;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameTextView= itemView.findViewById(R.id.tv_name);
        mEmailIdTextView= itemView.findViewById(R.id.tv_emailId);
        mPhoneNoTextView= itemView.findViewById(R.id.tv_phoneNo);
        mUserListLayout= itemView.findViewById(R.id.ll_user_list);
    }
}
