package com.dharmendra.intermediatekotlin.singleton

import com.dharmendra.intermediatekotlin.model.INoteModel
import com.dharmendra.intermediatekotlin.model.ITaskModel
import com.dharmendra.intermediatekotlin.model.NoteLoaclModel
import com.dharmendra.intermediatekotlin.model.TaskLocalModel
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope{
    val scope = Toothpick.openScope(this).apply {
        installModules(ApplicationModule)
    }
}

object ApplicationModule:Module(){
    init {
        bind(INoteModel::class.java).toInstance(NoteLoaclModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}