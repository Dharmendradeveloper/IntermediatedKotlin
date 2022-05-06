package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Note

class NoteViewModel:ViewModel() {
    public fun getFakeData():MutableList<Note> = mutableListOf(Note("Note 1"),Note("Note 2"))
}