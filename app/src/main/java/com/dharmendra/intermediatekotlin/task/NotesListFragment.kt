package com.dharmendra.intermediatekotlin.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.adapter.NoteAdapter
import com.dharmendra.intermediatekotlin.R
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        recycler.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(mutableListOf(
            Note("Desc 1"),
        Note("Desc 2")
        ))
        recycler.adapter = adapter
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }
}