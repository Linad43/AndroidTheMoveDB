package com.example.androidthemovedb

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidthemovedb.databinding.ActivityMainBinding
import com.example.androidthemovedb.models.forList.Result
import com.example.androidthemovedb.service.RecyclerAdapter
import com.example.androidthemovedb.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var movesAdapter: RecyclerAdapter
    private val listMoves = listOf<Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()

        viewModel.movesLiveData.observe(this) { response ->
            when (response) {
                is Resources.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    response.data?.let {
                        movesAdapter.differ.submitList(it.results)
                    }
                }

                is Resources.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is Resources.Error -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun initAdapter() {
        movesAdapter = RecyclerAdapter()
        binding.recyclerRV.layoutManager = LinearLayoutManager(this)
        binding.recyclerRV.adapter = movesAdapter
    }
}