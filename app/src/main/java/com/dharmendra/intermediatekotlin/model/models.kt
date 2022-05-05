package com.dharmendra.intermediatekotlin

data class Task @JvmOverloads constructor(
    var titel:String,
    val todo:MutableList<Todo>? = mutableListOf(),
    var tag:Tag?=null)

data class Todo( var description:String,
            var isComplete:Boolean=false)


data class Note(
    var description: String,
    private var tag:Tag?=null)

data class Tag(private val name:String,
          private val ColourResId:Int)