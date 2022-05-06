package com.dharmendra.intermediatekotlin.task

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.extfunction.removeStrikeThrough
import com.dharmendra.intermediatekotlin.extfunction.setStrikeThrough
import com.dharmendra.intermediatekotlin.todo.TodoView
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,attrs: AttributeSet?=null,
    defStyleAttr:Int=1):ConstraintLayout(context,attrs,defStyleAttr) {
    lateinit var task:Task
    public fun initView(task:Task,todoCheckedCallback:(Int,Boolean)->Unit){
        this.task = task
        titleView.text = task.titel
        task.todo?.forEachIndexed() { todoIndexed,todo->
            val todoView = (LayoutInflater.from(context).inflate(R.layout.view_todo,
                todoContainer,false) as TodoView).apply{
                    initView(todo){isChecked->
                        todoCheckedCallback.invoke(todoIndexed,isChecked)
                        if (isTaskCompleted())
                            this@TaskView.titleView.setStrikeThrough()
                        else
                            this@TaskView.titleView.removeStrikeThrough()
                    }
            }
            todoContainer.addView(todoView)
        }
    }

    private fun isTaskCompleted():Boolean=task.todo!!.filter{!it.isComplete}.isEmpty()

//    private fun createStrikeThrough(){
//        titleView.apply{
//            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//        }
//    }

//    private fun removeStrikeThrough(){
//        titleView.apply{
//            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG.inv()
//        }
//    }
}