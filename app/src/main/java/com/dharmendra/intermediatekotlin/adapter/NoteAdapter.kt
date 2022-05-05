package com.dharmendra.intermediatekotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.notes.NoteView
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.foundations.BaseRecyclerAdapter

class NoteAdapter( notesList:MutableList<Note> = mutableListOf()):
    BaseRecyclerAdapter<Note>(notesList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes,parent,false))


inner class MyViewHolder(itemView: View) : BaseViewHolder<Note>(itemView) {
    override fun onBind(data: Note) {
        (itemView as NoteView).initView(data)
    }

}
}