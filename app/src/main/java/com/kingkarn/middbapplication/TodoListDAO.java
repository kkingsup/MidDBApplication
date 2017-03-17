package com.kingkarn.middbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by DELL on 25/2/2560.
 */

public class TodoListDAO {
    private SQLiteDatabase database; //14
    private DBHelper dbHelper; //14

    public TodoListDAO(Context context) {
        dbHelper = new DBHelper(context); //16
    }

    public void open() { //17
        database = dbHelper.getWritableDatabase(); //17
    }

    public void close() { //18
        dbHelper.close();
    }

    public ArrayList<TodoList> getAllTodoList() { //19 40
        ArrayList<TodoList> todoList = new ArrayList<TodoList>(); //40
        Cursor cursor = database.rawQuery("SELECT * FROM todo_list;", null);
        cursor.moveToFirst();
        TodoList todoList1; // 41
        while (!cursor.isAfterLast()) {
            todoList1 = new TodoList(); //42
            todoList1.setId(cursor.getInt(0)); //42
            todoList1.setTodoText(cursor.getString(1));//42
            todoList.add(todoList1);//42
            cursor.moveToNext();//42
        }
        cursor.close();
        return todoList;
    }

    public void add(TodoList todoList) { //32
        TodoList newTodoList = new TodoList();
        newTodoList = todoList;

        ContentValues values = new ContentValues();
        values.put("todo_text", newTodoList.getTodoText());
        this.database.insert("todo_list", null, values);
        Log.d("Todo List Demo::: ", "Add OK!!");
    }

}
