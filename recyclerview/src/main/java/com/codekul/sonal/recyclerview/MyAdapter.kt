package com.codekul.sonal.recyclerview

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by sonal on 6/12/17.
 */
class MyAdapter(private val list:ArrayList<MyDataClass>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder:MyAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindItems(data : MyDataClass){
            val _textView1:TextView = itemView.findViewById(R.id.tvVersion)
            val _textView2:TextView = itemView.findViewById(R.id.tvName)
            val _imageView: ImageView = itemView.findViewById(R.id.imgVw)
            _textView1.text = data.name
            _textView2.text = data.version
            _imageView.setImageResource(data.imageicon)

            //set the onclick listener for the singlt list item
            itemView.setOnClickListener({
                Log.e("ItemClicked", data.name)
                Log.e("ItemClicked", data.version)
            })
        }

    }
}