package com.example.postapi

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface ApiService {
    @POST("users")  // Change this to your API endpoint
    fun createUser(@Body user: UserRequest): Call<UserResponse>
}
