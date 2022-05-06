package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.model.NoteModel
import com.dharmendra.intermediatekotlin.notes.NoteListViewContract

class NoteViewModel:ViewModel(),NoteListViewContract {
    private val noteModel = NoteModel()
    var mutableLiveData:MutableLiveData<MutableList<Note>> = MutableLiveData()
    val liveData : LiveData<MutableList<Note>> = mutableLiveData

    init {
        mutableLiveData.postValue(noteModel.getFakeData())
    }

}