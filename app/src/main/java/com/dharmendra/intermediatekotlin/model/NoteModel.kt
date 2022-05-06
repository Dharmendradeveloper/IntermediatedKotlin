package com.dharmendra.intermediatekotlin.model

import com.dharmendra.intermediatekotlin.Note

class NoteModel {
    public fun getFakeData():MutableList<Note> = mutableListOf(
        Note("Note 1 observer"),
        Note("Note 2")
    )

}