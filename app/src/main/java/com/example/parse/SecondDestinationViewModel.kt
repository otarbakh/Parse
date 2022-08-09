package com.example.parse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parse.Model.HomeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SecondDestinationViewModel : ViewModel() {

    private val _data =
        MutableStateFlow<Resource<List<HomeModel.Content>>>(Resource.Loader(true))
    val data = _data.asStateFlow()

     suspend fun getMyData() {

        _data.value = Resource.Loader(true)
        val response = RetrofitBuilder.getHomeModel().getHomeModel()
        response.body()?.let { data ->
            when {response.isSuccessful -> {
                _data.value = Resource.Success(data.content)
            }
                else -> {
                    val errorBody = response.errorBody()
                    _data.value = Resource.Error(errorBody.toString())
                }
            }
            _data.value = Resource.Loader(false)
        }
    }

}



sealed class Resource<T:Any> {
    data class Success<T:Any>(val data: T) : Resource<T>()
    data class Error<T:Any>(val error: String) : Resource<T>()
    data class Loader<T:Any>(val isLoading: Boolean) : Resource<T>()
}