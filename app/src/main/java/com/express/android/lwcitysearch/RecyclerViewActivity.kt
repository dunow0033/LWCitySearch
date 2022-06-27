package com.express.android.lwcitysearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.express.android.lwcitysearch.databinding.ActivityRecyclerViewBinding

//import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityRecyclerViewBinding

    private val binding get() = _binding

    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    fun createData() {
        val item = ArrayList<String>()

        item.add("Java")
        item.add("C++")
        item.add("Android")
        item.add("iOS")
        item.add("PHP")

        recyclerViewAdapter.setListData(item)
        recyclerViewAdapter.notifyDataSetChanged()
    }
}