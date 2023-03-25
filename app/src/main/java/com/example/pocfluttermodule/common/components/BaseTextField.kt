package com.example.pocfluttermodule.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pocfluttermodule.ui.theme.errorColor

@Composable
fun BaseTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    validationRegex: Regex,
    errorMessage: String
) {
    val isValid = validationRegex.matches(value)

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = label)
        TextField(
            value = value,
            onValueChange = { newValue ->
                onValueChange(newValue)
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        if (!isValid) {
            Text(
                text = errorMessage,
                color = errorColor,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}