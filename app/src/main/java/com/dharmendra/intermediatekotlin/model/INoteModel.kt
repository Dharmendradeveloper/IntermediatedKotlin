package com.dharmendra.intermediatekotlin.model

import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.Task

interface INoteModel {
    fun addNote(note: Note, callback: SuccessCallback)
    fun updateNote(note: Note, callback: SuccessCallback)
    fun deleteNote(note: Note, callback: SuccessCallback)
    fun retrieveNote():List<Note>
    fun getFakeData():MutableList<Note>
}