package com.example.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sample1(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
            ) {
                Text(
                    text = "アイテム1",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Red)
            ) {
                Text(
                    text = "アイテム2",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(25.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Green)
            ) {
                Text(
                    text = "アイテム3",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .background(Color.Blue)
            ) {
                Text(
                    text = "アイテム4",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(75.dp)
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .background(Color.Yellow)
            ) {
                Text(
                    text = "アイテム5",
                    fontSize = 18.sp
                )
            }
        }
    }
}