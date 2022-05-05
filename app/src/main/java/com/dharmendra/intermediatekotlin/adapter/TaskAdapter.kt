package com.dharmendra.intermediatekotlin.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.foundations.BaseRecyclerAdapter
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
            itemView.titleView.text = data.titel
            data.todo?.forEach { todo ->
                val todoView = (LayoutInflater.from(itemView.context).inflate(
                    R.layout.view_todo,itemView.todoContainer,false) as TodoView).apply{
                        initView(todo)

//                    descriptionView.text = todo.description
//                    completeCheckBox.isChecked = todo.isComplete
//                    if (completeCheckBox.isChecked)
//                        descriptionView.paintFlags = descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//                    // set Listener on checkbox
//                    completeCheckBox.setOnCheckedChangeListener{button,isChecked ->
//                        if(isChecked){
//                            descriptionView.paintFlags = descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//                        }
//                    }
                }
//                todoView.descriptionView.text = todo.description
//                todoView.completeCheckBox.isChecked = todo.isComplete
                itemView.todoContainer.addView(todoView)
            }
        }

    }

}


