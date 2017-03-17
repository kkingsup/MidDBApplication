package com.kingkarn.middbapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 25/2/2560.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String databaseName = "todolist.sqlite"; // 9
    private static final int databaseVersion = 1; //9
    Context myContext; //9

    private static final String tbName = "CREATE TABLE todo_list (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "todo_text TEXT" +
            ");"; //11


    public DBHelper(Context context) { //10
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tbName); //12
        String insertData1 = "INSERT INTO todo_list (todo_text) VALUES ('Todo Text 1');";
        db.execSQL(insertData1); //12.1
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
