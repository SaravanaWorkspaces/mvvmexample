package com.skc.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.skc.mvvmexample.adapter.RecyclerAdapter
import com.skc.mvvmexample.model.IceCream
import com.skc.mvvmexample.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var adapter : RecyclerAdapter
    lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        adapter                    = RecyclerAdapter(this, ArrayList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter       = adapter

        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(
            MainActivityViewModel::class.java)

        viewModel.getIceCreamList().observe(this, Observer<List<IceCream>> { iceCreams->
            adapter.refreshAdapter(iceCreams)
        })
    }
}