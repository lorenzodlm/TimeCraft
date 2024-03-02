package com.example.timecraft.ui.task;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timecraft.R;
import com.example.timecraft.ui.task.Adapter.ToDoAdapter;
import com.example.timecraft.ui.task.Model.ToDoModel;
import com.example.timecraft.ui.task.utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;
import java.util.List;

public class Tasks extends AppCompatActivity implements DialogCloseListener {

    private RecyclerView tasksRecyclerView;
    private ToDoAdapter tasksAdapter;
    private FloatingActionButton fab;

    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task);
        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        db.openDatabase();

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(db, this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        fab = findViewById(R.id.fab);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddNewTask().show(getSupportFragmentManager(), AddNewTask.TAG);
            }
        });

        loadTasksFromDatabase();
    }

    private void loadTasksFromDatabase() {
        List<ToDoModel> tasks = db.getAllTasks();
        Collections.reverse(tasks);
        tasksAdapter.setTasks(tasks);
    }

    @Override
    public void handleDialogClose() {
<<<<<<< Updated upstream

        loadTasksFromDatabase();
    }

     @Override
     public void handleDialogClose(DialogInterface dialog) {
         refreshTaskList();
=======
        loadTasksFromDatabase();
    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {
        // Refresh the task list when the dialog is closed
        refreshTaskList();
>>>>>>> Stashed changes
    }

    private void refreshTaskList() {
        // Retrieve the updated task list from the database
        List<ToDoModel> updatedTaskList = db.getAllTasks();
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
        // Reverse the task list to display the latest tasks first
        Collections.reverse(updatedTaskList);

        // Update the RecyclerView with the updated task list
        tasksAdapter.setTasks(updatedTaskList);
        tasksAdapter.notifyDataSetChanged();
    }
}
