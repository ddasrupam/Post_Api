package com.example.postapi

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CreateUserScreen(userViewModel: UserViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val responseMessage by userViewModel.responseMessage

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Create User", style = MaterialTheme.typography.bodyMedium)

        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Button(
            onClick = { userViewModel.createUser(name, email) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Submit")
        }

//        Text(text = responseMessage, modifier = Modifier.padding(8.dp))
    }
}
