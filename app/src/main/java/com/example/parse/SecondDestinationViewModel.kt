package com.example.parse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parse.Model.HomeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondDestinationViewModel : ViewModel() {
    private val _data = MutableStateFlow<List<HomeModel.Content>>(listOf())
    val data = _data.asStateFlow()

    fun getHomesData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitBuilder.getHomeModel().getHomeModel()
            if (response.isSuccessful && response.body() != null) {
                val data = response.body()
                _data.emit(data?.content ?: emptyList())
            }
        }
    }
}