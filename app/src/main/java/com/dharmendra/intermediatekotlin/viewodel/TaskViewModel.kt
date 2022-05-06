package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.model.ITaskModel
import com.dharmendra.intermediatekotlin.model.TaskLocalModel
import com.dharmendra.intermediatekotlin.task.TaskListViewContract
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class TaskViewModel:ViewModel(),TaskListViewContract {
    @Inject
    lateinit var taskModel:ITaskModel
    var _mutableLiveData:MutableLiveData<MutableList<Task>> = MutableLiveData()
    val liveData : LiveData<MutableList<Task>> = _mutableLiveData
     init {
         val scope = Toothpick.openScope(this)
         scope.installModules(
             Module().apply {
                 bind(ITaskModel::class.java).toInstance(TaskLocalModel())
             }
         )
         Toothpick.inject(this,scope)
         _mutableLiveData.postValue(taskModel.getFakeData())
     }


    override fun onTodoUpdated(taskIndex: Int, toDoIndex: Int, isComplete: Boolean) {
        _mutableLiveData.value?.get(taskIndex)?.todo?.get(toDoIndex)?.isComplete = isComplete
    }
}