package com.example.todolist.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private final LiveData<List<TaskEntry>> tasks;
    private final AppDatabase database;

    public MainViewModel(@NonNull Application application) {
        super(application);
        database = AppDatabase.getInstance(this.getApplication());
        tasks = database.taskDao().loadAllTask();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }

    public LiveData<TaskEntry> getTaskById(int taskId) {
        return database.taskDao().loadTaskById(taskId);
    }
}
