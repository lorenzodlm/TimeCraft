package com.example.timecraft.ui.task;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

//import androidx.annotation.Nullable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.timecraft.R;
import com.example.timecraft.ui.task.Adapter.ToDoAdapter;
import com.example.timecraft.ui.task.Model.ToDoModel;
import com.example.timecraft.ui.task.utils.DatabaseHandler;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.jetbrains.annotations.NotNull;

public class AddNewTask extends BottomSheetDialogFragment {
    private OnTaskAddedListener listener;
    public static final String TAG = "AddNewTask";

    private EditText newTaskText;
    private Button newTaskSaveButton;
    private DatabaseHandler db;

    public interface OnTaskAddedListener{
        void onTaskAdded();
    }

    public void setOnTaskAddedListener(OnTaskAddedListener listener){
        this.listener = listener;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.DialogStyle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_task, container, false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newTaskText = getView().findViewById(R.id.newTaskText);
        newTaskSaveButton = getView().findViewById(R.id.newTaskButton);

        db = new DatabaseHandler(getActivity());
        db.openDatabase();

        boolean isUpdate = false;
        final Bundle bundle = getArguments();
        if (bundle != null) {
            isUpdate = true;
            String task = bundle.getString("task");
            newTaskText.setText(task);
            if (task.length() > 0)
                newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.orange));
        }

        newTaskText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    newTaskSaveButton.setEnabled(false);
                    newTaskSaveButton.setTextColor(Color.GRAY);
                } else {
                    newTaskSaveButton.setEnabled(true);
                    newTaskSaveButton.setTextColor(ContextCompat.getColor(getContext(), R.color.orange));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        final boolean finalIsUpdate = isUpdate;
        boolean finalIsUpdate1 = isUpdate;
        newTaskSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = newTaskText.getText().toString();
                Log.d(TAG, "Save button clicked. Task text: " + text);
                if (finalIsUpdate1) {
                    db.updateTask(bundle.getInt("id"), text);

                } else {
                    ToDoModel task = new ToDoModel();
                    task.setTask(text);
                    task.setStatus(0);
                    db.insertTask(task);
                    if(listener!=null){
                        listener.onTaskAdded();
                        Log.d(TAG, "Listener triggered: onTaskAdded()");
                    }
                }
                dismiss();
            }
        });
    }
    @Override
//    public void onDismiss(DialogInterface dialog) {
//        super.onDismiss(dialog);
//        Log.d(TAG, "Dialog dismissed");
//        Activity activity = getActivity();
//        if (activity instanceof DialogCloseListener)
//            ((DialogCloseListener) activity).handleDialogClose(dialog);
//    }
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        if (getActivity() instanceof OnTaskAddedListener) {
            ((OnTaskAddedListener) getActivity()).onTaskAdded();
        }
    }

}
