package com.siraj.todoapp.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TasksRepository  {
    private static final String LOG_TAG = TasksRepository.class.getSimpleName();
    private LiveData<List<TaskEntry>> tasks;
    private TaskDao taskDao;
    AppDatabase database;
    public TasksRepository(AppDatabase database) {
        this.database = database;
    }


    public LiveData<List<TaskEntry>> getloadAllTasks() {
        tasks = database.taskDao().loadAllTasks();
        return tasks;
    }


    public LiveData<TaskEntry> getloadTaskById(int taskId) {
        return database.taskDao().loadTaskById(taskId);
    }

    public void deleteTasks(TaskEntry taskEntry) {
        database.taskDao().deleteTask(taskEntry);
    }

    public void updateTaskById(TaskEntry task) {
        database.taskDao().updateTask(task);
    }
}
