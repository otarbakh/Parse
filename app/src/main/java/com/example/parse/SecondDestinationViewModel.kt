package com.example.parse

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parse.Model.File
import com.example.parse.Model.MYmodels
import kotlinx.coroutines.launch

class SecondDestinationViewModel : ViewModel() {
    fun getMYmodel() {
        viewModelScope.launch {
            val myResponse = RetrofitBuilder.getVehicleService().getVehicleModel()

            if (myResponse.isSuccessful){
                val response:File? = myResponse.body()

                Log.d("oto","${response?.size}")
            }
            else{
                val errorResponse = myResponse.errorBody()
                Log.d("vaime viqrashebi","$errorResponse")
            }
        }
    }
}