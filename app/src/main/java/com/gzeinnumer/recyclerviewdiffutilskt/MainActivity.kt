package com.gzeinnumer.recyclerviewdiffutilskt

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var data: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_data.setHasFixedSize(true)
        rv_data.layoutManager = LinearLayoutManager(this)
        initData()
        val myAdapter = MyAdapter(data)
        rv_data.setAdapter(myAdapter)
        btn_insert.setOnClickListener {
            val newList: MutableList<String> =
                ArrayList()
            for (i in 0..2) newList.add(UUID.randomUUID().toString())
            myAdapter.insertData(newList)
            rv_data.smoothScrollToPosition(myAdapter.itemCount - 1)
        }
        btn_update.setOnClickListener {
            val updateList: MutableList<String> =
                ArrayList()
            for (i in 0..2) updateList.add(UUID.randomUUID().toString())
            myAdapter.updateData(updateList)
        }
    }

    private fun initData() {
        for (i in 0..2) data.add(UUID.randomUUID().toString())
    }
}