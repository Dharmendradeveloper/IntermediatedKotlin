package com.dharmendra.intermediatekotlin.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.TextView
import com.dharmendra.intermediatekotlin.Note
import kotlinx.android.synthetic.main.item_notes.view.*

class NoteView @JvmOverloads constructor(context: Context,
attrs: AttributeSet?=null,
defStyleAttr: Int=1): ConstraintLayout(context,attrs,defStyleAttr) {

    fun initView(note: Note) {
        notes.text = note.description
    }
}