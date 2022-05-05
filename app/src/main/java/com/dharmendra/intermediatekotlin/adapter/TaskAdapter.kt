package com.dharmendra.intermediatekotlin.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.foundations.BaseRecyclerAdapter
import com.dharmendra.intermediatekotlin.task.TaskView
import com.dharmendra.intermediatekotlin.todo.TodoView
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TaskAdapter(taskList:MutableList<Task> = mutableListOf()):
    BaseRecyclerAdapter<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MyViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_task,
            parent,false))

    inner class MyViewHolder(itemView: View):BaseViewHolder<Task>(itemView) {
        override fun onBind(data: Task) {
            (itemView as TaskView).initView(data)
        }

    }

}


