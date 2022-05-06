package com.dharmendra.intermediatekotlin.task

interface TaskListViewContract {
    fun onTodoUpdated(task:Int,toIndex:Int,isComplete:Boolean)
}