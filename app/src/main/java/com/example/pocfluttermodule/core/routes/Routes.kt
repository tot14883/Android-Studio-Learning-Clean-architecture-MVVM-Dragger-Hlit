package com.example.pocfluttermodule

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pocfluttermodule.presentation.authentication.screens.LoginScreen
import com.example.pocfluttermodule.presentation.authentication.viewModels.AuthenViewModel


@Composable
fun routes() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RoutesList.Login.route,
     ) {

        composable(RoutesList.Login.route) {
            val viewModel = hiltViewModel<AuthenViewModel>()
            LoginScreen(viewModel)
        }

        composable(RoutesList.Register.route) {

        }
    }
}