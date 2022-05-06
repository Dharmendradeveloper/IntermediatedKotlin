package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.Todo

class TaskViewModel:ViewModel() {
    var _mutableLiveData:MutableLiveData<MutableList<Task>> = MutableLiveData()
    val liveData : LiveData<MutableList<Task>> = _mutableLiveData
     init {
         _mutableLiveData.postValue(getFakeData())
     }

    fun getFakeData():MutableList<Task> = mutableListOf(
        Task("Task 1 observer", mutableListOf(Todo("Todo 1"),Todo("Todo 2"))),
        Task("Task 2", mutableListOf(Todo("Todo task 1"),Todo("Todo task 2")))
    )
}