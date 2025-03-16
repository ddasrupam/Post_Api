package com.example.postapi

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    var responseMessage = mutableStateOf("")

    fun createUser(name: String, email: String) {
        val userRequest = UserRequest(name, email)
        val call = RetrofitClient.instance.createUser(userRequest)

        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    responseMessage.value = "User Created: ${response.body()?.name}"
                } else {
                    responseMessage.value = "Failed: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                responseMessage.value = "Error: ${t.message}"
            }
        })
    }
}
