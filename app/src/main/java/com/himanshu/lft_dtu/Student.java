package com.himanshu.lft_dtu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Himanshu on 1/31/2016.
 */
public class Student {
    private int id;
    private String student_name;

    public Student(String name) {
        student_name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return student_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.student_name = name;
    }
}
