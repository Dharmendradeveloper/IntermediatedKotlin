package com.dharmendra.intermediatekotlin.foundations

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dharmendra.intermediatekotlin.adapter.TaskAdapter

abstract class BaseRecyclerAdapter<T:Any>(protected val masterList:MutableList<T> = mutableListOf()) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun getItemViewType(position: Int): Int = if (position == 0){
        TYPE_ADD_BUTTON
    }else{
        TYPE_INFO
    }
    override fun getItemCount(): Int = masterList.size

    fun updateList(list:MutableList<T>){
        val result = DiffUtil.calculateDiff(DiffUtilCallbackImpl<T>(masterList,list))
        masterList.clear()
        masterList.addAll(list)
        result.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder){
            holder.onBind(Unit,position-1)
        }else {
            (holder as BaseViewHolder<T>).onBind(masterList[position-1],position-1)
        }
    }


     abstract class BaseViewHolder<E>(val view: View):RecyclerView.ViewHolder(view){
        abstract fun onBind(data:E,listIndex:Int)
    }

    abstract class AddButtonViewHolder(view:View):BaseViewHolder<Unit>(view)

    companion object{
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

    class DiffUtilCallbackImpl<T>(val oldList:MutableList<T>,val newList:MutableList<T>): DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}