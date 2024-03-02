package com.example.timecraft.ui.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.timecraft.R;
import com.example.timecraft.ui.task.Adapter.ToDoAdapter;
import com.example.timecraft.ui.task.Model.ToDoModel;
import com.example.timecraft.ui.task.utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks extends AppCompatActivity implements AddNewTask.OnTaskAddedListener {

    private RecyclerView tasksRecyclerView;
    private ToDoAdapter tasksAdapter;
    private FloatingActionButton fab;

    private List<ToDoModel> taskList;
    protected DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_task);

        fab.setOnClickListener(v -> {
            AddNewTask addNewTaskFragment = new AddNewTask();
            addNewTaskFragment.setOnTaskAddedListener(this);
            addNewTaskFragment.show(getSupportFragmentManager(),AddNewTask.TAG);
        });


        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        db.openDatabase();

        taskList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(db, this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        fab = findViewById(R.id.fab);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper(tasksAdapter));
        itemTouchHelper.attachToRecyclerView(tasksRecyclerView);

        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        tasksAdapter.setTasks(taskList);

    }

//    @Override
//    public void handleDialogClose(DialogInterface dialog){
//        Log.d("Tasks.java","Dialog closed");
//        taskList = db.getAllTasks();
//        Collections.reverse(taskList);
//        tasksAdapter.setTasks(taskList);
//        tasksAdapter.notifyDataSetChanged();
//    }

    @Override
    public void onTaskAdded() {
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        tasksAdapter.setTasks(taskList);
        tasksAdapter.notifyDataSetChanged();
    }
}