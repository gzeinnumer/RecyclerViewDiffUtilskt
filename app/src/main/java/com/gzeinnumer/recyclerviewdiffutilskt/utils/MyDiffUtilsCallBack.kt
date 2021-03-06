package com.gzeinnumer.recyclerviewdiffutilskt.utils

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtilsCallBack(
    private val oldList: List<String>,
    private val newList: List<String>
) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

}
