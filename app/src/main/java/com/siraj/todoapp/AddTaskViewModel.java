package com.siraj.todoapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.siraj.todoapp.database.AppDatabase;
import com.siraj.todoapp.database.TaskEntry;
import com.siraj.todoapp.database.TasksRepository;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;
    private final TasksRepository tasksRepository;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        // task = database.taskDao().loadTaskById(taskId);
        tasksRepository = new TasksRepository(database);
        task = tasksRepository.getloadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }

    public void updateTask(TaskEntry task) {
        tasksRepository.updateTaskById(task);
    }
}