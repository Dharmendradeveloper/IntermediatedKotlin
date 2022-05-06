package com.dharmendra.intermediatekotlin.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.adapter.NoteAdapter
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.viewodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {
    lateinit var touchActionDelegate: TouchActionDelegate
    lateinit var noteViewModel:NoteViewModel
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context?.let {
            if (it is TouchActionDelegate)
                touchActionDelegate = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        recycler.layoutManager = LinearLayoutManager(context)
         adapter = NoteAdapter(touchActionDelegate = touchActionDelegate)
        recycler.adapter = adapter
    }

    private fun bindViewModel(){
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.liveData.observe(viewLifecycleOwner, Observer { noteList->
            adapter.updateList(noteList)
        })
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchActionDelegate{
        fun onAddButtonClicked(value:String)
    }
}