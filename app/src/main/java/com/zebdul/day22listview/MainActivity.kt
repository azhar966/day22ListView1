package com.zebdul.day22listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.zebdul.day22listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //use viewBinding to save time
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //give data for our list view
        val taskList = arrayListOf<String>()
        taskList.add("Go to Gym")
        taskList.add("Attend Meeting")
        taskList.add("Make A ner project")
        taskList.add("15 minute Meditation")
        taskList.add("5 minute power nape")

        //make an adapter to implement data in xml file using adapter
        // ArrayAdapter(context, Resource, Array)
        val adapterForMyListView = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,taskList)

        //intialize your list from xml with ViewBinding
        binding.listView.adapter = adapterForMyListView

        //to see something when onClickEvent happer on each item
        //when item clicked -> make a val text pass data with help of string and
        //view because we change it to text and string then set it to the Toast message
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val text = "You Clicked on:  " + (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}