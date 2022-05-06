package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.Todo
import com.dharmendra.intermediatekotlin.model.TaskModel
import com.dharmendra.intermediatekotlin.task.TaskListViewContract

class TaskViewModel:ViewModel(),TaskListViewContract {
    private val taskModel = TaskModel()
    var _mutableLiveData:MutableLiveData<MutableList<Task>> = MutableLiveData()
    val liveData : LiveData<MutableList<Task>> = _mutableLiveData
     init {
         _mutableLiveData.postValue(taskModel.getFakeData())
     }


    override fun onTodoUpdated(taskIndex: Int, toDoIndex: Int, isComplete: Boolean) {
        _mutableLiveData.value?.get(taskIndex)?.todo?.get(toDoIndex)?.isComplete = isComplete
    }
}