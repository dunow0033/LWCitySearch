package com.express.android.lwcitysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.express.android.lwcitysearch.databinding.ActivitySecondBinding

//import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySecondBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("user")
        val password = intent.getStringExtra("password")

        binding.tvWelcome.setText("Welcome ${username}, you entered ${password}")

    }
}