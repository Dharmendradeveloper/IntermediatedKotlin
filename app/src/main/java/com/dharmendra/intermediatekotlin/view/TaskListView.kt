package com.dharmendra.intermediatekotlin.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.adapter.TaskAdapter
import com.dharmendra.intermediatekotlin.task.TaskListFragment
import com.dharmendra.intermediatekotlin.task.TaskListViewContract
import kotlinx.android.synthetic.main.fragment_task_list.view.*

class TaskListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttrs) {

    private lateinit var adapter: TaskAdapter
    private lateinit var touchActionDelegate: TaskListFragment.TouchActionDelegate
    private lateinit var taskListViewContract: TaskListViewContract

    fun initView(taDelegate: TaskListFragment.TouchActionDelegate,taskListViewContract: TaskListViewContract) {
        setDelegate(taDelegate,taskListViewContract)
        setUpView()
    }

    private fun setUpView() {
        recycler.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(touchActionDelegate = touchActionDelegate,taskListViewContract =taskListViewContract)

        recycler.adapter = adapter
    }

    private fun setDelegate(
        taDelegate: TaskListFragment.TouchActionDelegate,
        tlViewContract: TaskListViewContract
    ) {
        touchActionDelegate = taDelegate
        taskListViewContract = tlViewContract
    }

    public fun updateList(list:MutableList<Task>){
        adapter.updateList(list)
    }


}