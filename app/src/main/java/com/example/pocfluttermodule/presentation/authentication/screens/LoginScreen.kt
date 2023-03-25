package com.example.pocfluttermodule.presentation.authentication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pocfluttermodule.common.components.BaseTextField
import com.example.pocfluttermodule.presentation.authentication.viewModels.AuthenViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pocfluttermodule.domain.authentication.models.AuthenRequestModel

@Composable
fun LoginScreen(
    viewModel: AuthenViewModel = hiltViewModel()
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box (
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BaseTextField(
                label = "Username",
                value = username,
                onValueChange = { username = it },
                validationRegex = Regex("\\w+"),
                errorMessage = "Username must contain only letters, digits, or underscores"
            )

            BaseTextField(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                validationRegex = Regex("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])"),
                errorMessage = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character"
            )

            Button(
                onClick = {
                    viewModel.postLogin(AuthenRequestModel(email = "test1@gmail.com", password = "abc123456"))
                },
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}