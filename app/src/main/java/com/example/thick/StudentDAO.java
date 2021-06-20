package com.example.thick;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    void insertS(Student user);

    @Query("SELECT * FROM student")
    List<Student> getAllS();



}
