package com.dharmendra.intermediatekotlin.adapter

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.notes.NoteView
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.foundations.BaseRecyclerAdapter
import com.dharmendra.intermediatekotlin.navigation.NavigationActivity
import com.dharmendra.intermediatekotlin.task.NotesListFragment
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter( notesList:MutableList<Note> = mutableListOf(),val touchActionDelegate: NotesListFragment.TouchActionDelegate):
    BaseRecyclerAdapter<Note>(notesList) {

    override fun getItemCount(): Int = masterList.size+1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        if (viewType == TYPE_INFO){
            MyViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
            )

        }else {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button,
                parent,false))
        }


class MyViewHolder(itemView: View) : BaseViewHolder<Note>(itemView) {
    override fun onBind(data: Note) {
        (itemView as NoteView).initView(data)
    }
}

    inner class AddButtonViewHolder(view:View):BaseRecyclerAdapter.AddButtonViewHolder(view){
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)
            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }

    }
}