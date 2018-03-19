package com.codekul.sonal.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    private val items = ArrayList<MyDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        items.add(MyDataClass(R.drawable.ic_flower, "flower", "beautiful"))
        items.add(MyDataClass(R.drawable.ic_india, "Country", "My country"))
        items.add(MyDataClass(R.drawable.ic_question1, "Question", "questions"))
        items.add(MyDataClass(R.drawable.ic_boy, "Boy", "boy"))
        items.add(MyDataClass(R.drawable.ic_flower, "flower", "beautiful"))
        items.add(MyDataClass(R.drawable.ic_india, "Country", "My country"))
        items.add(MyDataClass(R.drawable.ic_question1, "Question", "questions"))
        items.add(MyDataClass(R.drawable.ic_boy, "Boy", "boy"))
        items.add(MyDataClass(R.drawable.ic_flower, "flower", "beautiful"))
        items.add(MyDataClass(R.drawable.ic_india, "Country", "My country"))
        items.add(MyDataClass(R.drawable.ic_question1, "Question", "questions"))
        items.add(MyDataClass(R.drawable.ic_boy, "Boy", "boy"))

        val adapter = MyAdapter(items)

        //now adding the adapter to recyclerView
        recyclerView.adapter = adapter
    }

}
