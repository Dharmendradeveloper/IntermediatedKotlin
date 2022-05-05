package com.dharmendra.intermediatekotlin.todo

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet

import androidx.constraintlayout.widget.ConstraintLayout

import android.widget.CompoundButton
import com.dharmendra.intermediatekotlin.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(context: Context,
attrs: AttributeSet?=null,
defStyleAttr: Int=1)  : ConstraintLayout(context,attrs,defStyleAttr) {

    fun initView(todo: Todo) {
        descriptionView.setText(todo.description)
        completeCheckBox.setChecked(todo.isComplete)
        if (todo.isComplete) {
            createStrikeThrough()
        }
        setUpCheckStateListener()
    }

    private fun setUpCheckStateListener() {
        completeCheckBox.setOnCheckedChangeListener {
                button: CompoundButton?, isChecked: Boolean ->
            if (isChecked)
                createStrikeThrough()
            else
                removeStrikeThrough()
        }
    }

    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()

        }
    }
}