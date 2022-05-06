package com.dharmendra.intermediatekotlin.viewodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dharmendra.intermediatekotlin.Note
import com.dharmendra.intermediatekotlin.model.INoteModel
import com.dharmendra.intermediatekotlin.model.NoteLoaclModel
import com.dharmendra.intermediatekotlin.notes.NoteListViewContract
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject

class NoteViewModel:ViewModel(),NoteListViewContract {
    @Inject
    lateinit var noteModel: INoteModel
    var mutableLiveData:MutableLiveData<MutableList<Note>> = MutableLiveData()
    val liveData : LiveData<MutableList<Note>> = mutableLiveData

    init {
        val scope = Toothpick.openScope(this)
        scope.installModules(object :Module(){
            init {
                bind(INoteModel::class.java).toInstance(NoteLoaclModel())
            }
        })
        Toothpick.inject(this,scope)
        mutableLiveData.postValue(noteModel.getFakeData())
    }

}