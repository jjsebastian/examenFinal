package com.utad.javierjimenez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

class TareaActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityTareaBinding
    private val binding: ActivityTareaBinding get() = _binding

    private val viewModel: HomeWorkViewModel by viewModels()
    private val adapter: TareaAdapter = TareaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHomeWork.layoutManager = LinearLayoutManager(this)
        binding.rvHomeWork.adapter = adapter

        viewModel.getUserName(this)
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.userName.observe(this){userName ->
            if(userName!= null){
                //TODO llamamos a la api
                viewModel.getHomeWork(userName)
            }
        }
        viewModel.uiState.observe(this){uiState ->
            if(uiState.response!= null){
                adapter.submitList(uiState.response)
            }

            if(uiState.isLoading){

            }else{

            }
        }

    }


}