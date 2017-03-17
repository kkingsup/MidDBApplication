package com.kingkarn.middbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView todoListView; //21

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoListView = (ListView) findViewById(R.id.todo_listView); //21

//        TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext()); //22
//        todoListDAO.open(); //22
//        ArrayList<String> myList = todoListDAO.getAllTodoList(); //22
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList); //23
//        todoListView.setAdapter(adapter); //23
//        todoListDAO.close();//24
    }

    @Override
    protected void onResume() { //38
        super.onResume();

        TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext()); //39
        todoListDAO.open(); //39
        ArrayList<TodoList> myList = todoListDAO.getAllTodoList(); //39 53

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList); //39
        MyListView adapter = new MyListView(this, myList); // 55
        todoListView.setAdapter(adapter); //39
        todoListDAO.close();//39
    }

    public boolean onCreateOptionsMenu(Menu menu) { //28
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_new) {
            Intent addNewIntent = new Intent(this, AddNewActivity.class); // 30
            startActivity(addNewIntent); //30
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
