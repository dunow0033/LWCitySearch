package com.express.android.lwcitysearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.of
import androidx.lifecycle.ViewModelStores.of
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.express.android.lwcitysearch.databinding.ActivityRecyclerViewBinding
import com.express.android.lwcitysearch.network.RetroInstance
import com.express.android.lwcitysearch.network.RetroService
import com.express.android.lwcitysearch.viewmodels.RecyclerActivityViewModel
//import com.express.android.lwcitysearch.viewmodels.RecyclerActivityViewModel
import retrofit2.Call
import retrofit2.Response
import java.util.Optional.of

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

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }

    fun createData() {
//        val item = ArrayList<RecyclerData>()
//
//        item.add(RecyclerData("Java", "Java description"))
//        item.add(RecyclerData("C++", "C++ description"))
//        item.add(RecyclerData("Android", "Android description"))
//        item.add(RecyclerData("iOS", "iOS description"))
//        item.add(RecyclerData("PHP", "PHP description"))
//
//        recyclerViewAdapter.setListData(item)
//        recyclerViewAdapter.notifyDataSetChanged()

//        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
//        val call = retroInstance.getDataFromAPI("newyork")
//        call.enqueue(object : retrofit2.Callback<RecyclerList>{
//            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
//                if(response.isSuccessful) {
//                    recyclerViewAdapter.setListData(response.body()?.items!!)
//                    recyclerViewAdapter.notifyDataSetChanged()
//                }
//            }
//            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
//                Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api.", Toast.LENGTH_LONG).show()
//            }
//        })

        val viewModel = ViewModelProvider(this).get(RecyclerActivityViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<RecyclerList> {
            if(it != null) {
                recyclerViewAdapter.setListData(it.items!!)
                recyclerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this@RecyclerViewActivity, "Error in getting data from api", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()
    }
}