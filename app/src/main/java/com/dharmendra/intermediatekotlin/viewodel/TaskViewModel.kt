package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.Todo
import com.dharmendra.intermediatekotlin.task.TaskListViewContract

class TaskViewModel:ViewModel(),TaskListViewContract {
    var _mutableLiveData:MutableLiveData<MutableList<Task>> = MutableLiveData()
    val liveData : LiveData<MutableList<Task>> = _mutableLiveData
     init {
         _mutableLiveData.postValue(getFakeData())
     }

    fun getFakeData():MutableList<Task> = mutableListOf(
        Task("Task 1 observer", mutableListOf(Todo("Todo 1"),Todo("Todo 2"))),
        Task("Task 2", mutableListOf(Todo("Todo task 1"),Todo("Todo task 2")))
    )

    override fun onTodoUpdated(taskIndex: Int, toDoIndex: Int, isComplete: Boolean) {
        _mutableLiveData.value?.get(taskIndex)?.todo?.get(toDoIndex)?.isComplete = isComplete
    }
}