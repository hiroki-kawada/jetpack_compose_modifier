package com.example.modifier

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Sample4(
    modifier: Modifier = Modifier
) {
    val editable = remember { mutableStateOf(true) }
    Column(
        modifier
            .fillMaxWidth()
            .background(Color.Gray)
    ) {
        if (editable.value) {
            Text("Text")
        }
        Button(
            onClick = { editable.value = !editable.value },
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = "表示切り替えボタン")
        }
    }
}
