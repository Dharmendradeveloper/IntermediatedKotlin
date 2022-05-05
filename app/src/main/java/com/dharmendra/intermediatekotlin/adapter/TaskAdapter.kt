package com.dharmendra.intermediatekotlin.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.foundations.BaseRecyclerAdapter
import com.dharmendra.intermediatekotlin.foundations.BaseRecyclerAdapter.*
import com.dharmendra.intermediatekotlin.navigation.NavigationActivity
import com.dharmendra.intermediatekotlin.task.TaskListFragment
import com.dharmendra.intermediatekotlin.task.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(taskList:MutableList<Task> = mutableListOf(),
                  val touchActionDelegate: TaskListFragment.TouchActionDelegate):
    BaseRecyclerAdapter<Task>(taskList) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        if (viewType == TYPE_INFO) {
            MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_task,
                    parent, false
                )
            )
        }else{
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button,
                parent,false))
        }

    override fun getItemCount(): Int {
        return masterList.size+1
    }

     class MyViewHolder(itemView: View):BaseViewHolder<Task>(itemView) {
        override fun onBind(data: Task) {
            (itemView as TaskView).initView(data)
        }
    }

      inner class AddButtonViewHolder(view:View):BaseRecyclerAdapter.AddButtonViewHolder(view){
         override fun onBind(data:Unit){
             view.buttonText.text = view.context.getString(R.string.add_button_task)
             view.setOnClickListener {
                 touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_TASK)
             }
         }
    }
}


