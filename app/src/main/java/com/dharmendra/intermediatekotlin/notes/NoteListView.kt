package com.dharmendra.intermediatekotlin.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.adapter.NoteAdapter
import com.dharmendra.intermediatekotlin.task.NotesListFragment
import kotlinx.android.synthetic.main.fragment_task_list.view.*

class NoteListView @JvmOverloads constructor(context:Context,
attrs:AttributeSet?=null,
defStyleAttrs:Int=1):ConstraintLayout(context,attrs,defStyleAttrs) {
    private lateinit var adapter: NoteAdapter
    private lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate : NoteListViewContract
    fun initView(taDelegate: NotesListFragment.TouchActionDelegate,daDelegate : NoteListViewContract) {
        setDelegate(taDelegate,daDelegate)
        setUpView()
    }

    private fun setUpView() {
        recycler.layoutManager = LinearLayoutManager(context)
        adapter = NoteAdapter(touchActionDelegate = touchActionDelegate,dataActionDelegate = dataActionDelegate)

        recycler.adapter = adapter
    }

    private fun setDelegate(
        taDelegate: NotesListFragment.TouchActionDelegate,
        daDelegate: NoteListViewContract,

        ) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    public fun updateList(list:MutableList<Note>){
        adapter.updateList(list)
    }
}