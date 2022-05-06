package com.dharmendra.intermediatekotlin.model

import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.Todo

class TaskModel {
    fun getFakeData():MutableList<Task> = mutableListOf(
        Task("Task 1 observer", mutableListOf(Todo("Todo 1"), Todo("Todo 2"))),
        Task("Task 2", mutableListOf(Todo("Todo task 1"), Todo("Todo task 2")))
    )

}