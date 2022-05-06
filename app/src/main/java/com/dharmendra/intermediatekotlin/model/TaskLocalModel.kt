package com.dharmendra.intermediatekotlin.model

import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor():ITaskModel{
    override fun addTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveTask(): List<Task> {
        TODO("Not yet implemented")
    }

    override fun getFakeData():MutableList<Task> = mutableListOf(
        Task("Task 1 observer", mutableListOf(Todo("Todo 1"), Todo("Todo 2"))),
        Task("Task 2", mutableListOf(Todo("Todo task 1"), Todo("Todo task 2")))
    )

}