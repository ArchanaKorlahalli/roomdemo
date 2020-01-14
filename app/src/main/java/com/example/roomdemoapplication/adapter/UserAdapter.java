package com.example.roomdemoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdemoapplication.R;
import com.example.roomdemoapplication.database.AppDatabase;
import com.example.roomdemoapplication.model.User;
import com.example.roomdemoapplication.viewholder.UserViewHolder;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context mContext;
    private List<User> mUserListData;
    private AppDatabase mAppDatabase;

    public UserAdapter(Context context, List<User> userDataList) {
        this.mContext= context;
        this.mUserListData= userDataList;
        mAppDatabase= AppDatabase.getAppDatabase(mContext);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.activity_user_list,parent,false);
        UserViewHolder userViewHolder= new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {
        final User user=mUserListData.get(position);
        holder.mNameTextView.setText(mUserListData.get(position).getmName());
        holder.mEmailIdTextView.setText(mUserListData.get(position).getmEmailId());
        holder.mPhoneNoTextView.setText(mUserListData.get(position).getmPhoneNo());

        holder.mUserListLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mAppDatabase.userDao().delete(user);
                Toast.makeText(mContext, "Value Deleted", Toast.LENGTH_SHORT).show();
                mUserListData.remove(position);
                notifyItemRemoved(position);
                return false;
            }
        });

        holder.mUserListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserListData.size();
    }
}
