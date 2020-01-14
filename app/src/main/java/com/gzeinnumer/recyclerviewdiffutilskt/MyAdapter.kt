package com.gzeinnumer.recyclerviewdiffutilskt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gzeinnumer.recyclerviewdiffutilskt.utils.MyDiffUtilsCallBack
import kotlinx.android.synthetic.main.item_data.view.*

class MyAdapter(private val data: MutableList<String>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_data,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        fun bindData(s: String?) {
            with(itemView){
                tv_name.text = s
            }
        }
    }

    fun insertData(newList: List<String>) {
        val diffUtilsCallBack = MyDiffUtilsCallBack(data, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallBack)
        data.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateData(updateList: List<String>) {
        val diffUtilsCallBack = MyDiffUtilsCallBack(data, updateList)
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallBack)
        data.clear()
        data.addAll(updateList)
        diffResult.dispatchUpdatesTo(this)
    }

}
