package com.dharmendra.intermediatekotlin.todo

import android.content.ComponentCallbacks
import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet

import androidx.constraintlayout.widget.ConstraintLayout

import android.widget.CompoundButton
import com.dharmendra.intermediatekotlin.Todo
import com.dharmendra.intermediatekotlin.extfunction.removeStrikeThrough
import com.dharmendra.intermediatekotlin.extfunction.setStrikeThrough
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(context: Context,
attrs: AttributeSet?=null,
defStyleAttr: Int=1)  : ConstraintLayout(context,attrs,defStyleAttr) {

    fun initView(todo: Todo,callbacks: ((Boolean) -> Unit)?=null) {
        descriptionView.setText(todo.description)
        completeCheckBox.setChecked(todo.isComplete)
        if (todo.isComplete) {
            descriptionView.setStrikeThrough()
        }
        setUpCheckStateListener(todo,callbacks )
    }

    private fun setUpCheckStateListener(todo:Todo,callbacks: ((Boolean)->Unit)?=null) {

        completeCheckBox.setOnCheckedChangeListener {
               _, isChecked->
            todo.isComplete = isChecked
            callbacks?.invoke(isChecked)
            if (isChecked)
                descriptionView.setStrikeThrough()
            else
                descriptionView.removeStrikeThrough()
        }
    }

//    private fun createStrikeThrough() {
//        descriptionView.apply {
//            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//        }
//    }

//    private fun removeStrikeThrough() {
//        descriptionView.apply {
//            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
//
//        }
//    }
}