package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Note

class NoteViewModel:ViewModel() {
    var mutableLiveData:MutableLiveData<MutableList<Note>> = MutableLiveData()
    val liveData : LiveData<MutableList<Note>> = mutableLiveData

    init {
        mutableLiveData.postValue(getFakeData())
    }

    public fun getFakeData():MutableList<Note> = mutableListOf(Note("Note 1 observer"),Note("Note 2"))
}