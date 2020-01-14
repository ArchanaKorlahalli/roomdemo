package com.example.roomdemoapplication.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdemoapplication.model.User;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface UserDao {

    @Query("select * from User")
    List<User> getAllUsers();

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Delete
    void delete(User user);

    @Query("update User set mEmailId = :emailID, mPhoneNo = :phoneNo where mName = :name")
    void updateUser(String emailID, String phoneNo, String name);

}
