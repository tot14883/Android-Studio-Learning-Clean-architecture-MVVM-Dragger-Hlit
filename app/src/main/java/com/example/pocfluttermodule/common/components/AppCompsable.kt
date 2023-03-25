package com.example.pocfluttermodule.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel


@Composable
fun AppComposable(
    viewModel: ViewModel,
    content: @Composable () -> Unit
) {
//    val isLoading by viewModel.loading.observeAsState(initial = false)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        content()
    }
//    if (isLoading) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            CircularProgressIndicator()
//        }
//    }
}