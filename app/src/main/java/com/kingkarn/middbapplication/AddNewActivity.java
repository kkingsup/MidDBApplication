package com.kingkarn.middbapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        final EditText newTodoListText = (EditText) findViewById(R.id.editTextAddTask); //33
        Button newTodoListBtn = (Button) findViewById(R.id.btnAddNewTask); //33

        newTodoListBtn.setOnClickListener(new View.OnClickListener() { //34
            @Override
            public void onClick(View v) {
                TodoList todoList = new TodoList(); //35
                todoList.setTodoText(String.valueOf(newTodoListText.getText())); //35

                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext()); //36
                todoListDAO.open(); //36
                todoListDAO.add(todoList); //36
                todoListDAO.close(); //36
                finish(); //37
            }
        });
    }

}
