package com.dharmendra.intermediatekotlin.task

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.adapter.TaskAdapter
import com.dharmendra.intermediatekotlin.Todo
import com.dharmendra.intermediatekotlin.viewodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {
    lateinit var touchActionDelegate: TouchActionDelegate
    lateinit var taskViewModel: TaskViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context?.let {
            if (it is TouchActionDelegate){
                touchActionDelegate = it
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        recycler.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(taskViewModel.getFakeData(),touchActionDelegate)
        recycler.adapter = adapter

    }

    private fun bindViewModel(){
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
//        fun newInstance(): TaskListFragment {
//            return TaskListFragment()
//        }
        // we can write something like this
        fun newInstance() = TaskListFragment()
    }

    interface TouchActionDelegate{
        fun onAddButtonClicked(value:String)
    }
}