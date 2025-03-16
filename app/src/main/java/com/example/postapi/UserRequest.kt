package com.example.postapi

data class UserRequest(
    val name: String,
    val email: String
)

data class UserResponse(
    val id: Int,
    val name: String,
    val email: String,
    val createdAt: String
)
