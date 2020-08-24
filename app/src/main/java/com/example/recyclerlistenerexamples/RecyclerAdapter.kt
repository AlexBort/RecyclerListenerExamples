package com.example.recyclerlistenerexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var itemList = mutableListOf<TestModel>()
    private lateinit var listener: RecyclerAdapter.ItemClickListener

    init {
        itemList.add(TestModel("test1"))
        itemList.add(TestModel("test2"))
        itemList.add(TestModel("test3"))
        itemList.add(TestModel("test4"))
        itemList.add(TestModel("test5"))
        itemList.add(TestModel("test6"))
        itemList.add(TestModel("test7"))
        itemList.add(TestModel("test8"))
        itemList.add(TestModel("test9"))
        itemList.add(TestModel("test10"))
        itemList.add(TestModel("test11"))
    }

    class ViewHolder(itemView: View, itemClickListener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var itemClickListener: ItemClickListener = itemClickListener

        fun bind(text: String) {
            (itemView as TextView).text = text
        }


        override fun onClick(view: View?) {
            itemClickListener.onItemClick(adapterPosition)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position].testText)
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

}