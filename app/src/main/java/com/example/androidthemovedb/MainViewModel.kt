package com.example.androidthemovedb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidthemovedb.data.MoveRepository
import com.example.androidthemovedb.models.forList.MoveForList
import com.example.androidthemovedb.utils.Resources
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repos: MoveRepository,
) : ViewModel() {
    val movesLiveData: MutableLiveData<Resources<MoveForList>> = MutableLiveData()
    var page = 1

    init {
        getMoves()
    }

    private fun getMoves() {
        viewModelScope.launch {
            movesLiveData.postValue(Resources.Loading())
            val response = repos.getMoves(page = page)
            if (response.isSuccessful) {
                response.body().let {
                    movesLiveData.postValue(Resources.Success(it))
                }
            } else {
                movesLiveData.postValue((Resources.Error(message = response.message())))
            }
        }
    }
}