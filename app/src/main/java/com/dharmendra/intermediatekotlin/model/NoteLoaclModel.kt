package com.dharmendra.intermediatekotlin.model

import com.dharmendra.intermediatekotlin.Note
import javax.inject.Inject

class NoteLoaclModel @Inject constructor():INoteModel {
    override fun addNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveNote(): List<Note> {
        TODO("Not yet implemented")
    }

    override fun getFakeData():MutableList<Note> = mutableListOf(
        Note("Note 1 observer"),
        Note("Note 2")
    )

}