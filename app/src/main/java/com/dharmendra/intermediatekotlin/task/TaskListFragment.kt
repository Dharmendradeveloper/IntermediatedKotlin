package com.dharmendra.intermediatekotlin.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.Task
import com.dharmendra.intermediatekotlin.adapter.TaskAdapter
import com.dharmendra.intermediatekotlin.Todo
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {
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
        recycler.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(mutableListOf(
            Task("One day is Done", mutableListOf(
            Todo("Day 3",true), Todo("Day 4",false)
        )),
        Task("Seven days are left", mutableListOf(Todo("Day 5",false), Todo("Day 6",true)))
        ))
        recycler.adapter = adapter
    }

    companion object {
        // TODO: Rename and change types and number of parameters
//        fun newInstance(): TaskListFragment {
//            return TaskListFragment()
//        }
        // we can write something like this
        fun newInstance() = TaskListFragment()
    }
}