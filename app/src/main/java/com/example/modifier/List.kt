package com.example.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController

@Composable
fun List(
    navController: NavController,
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
                    .clickable { navController.navigate("sample1") }
            ) {
                Text(
                    text = "Sample1",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate("sample2") }
            ) {
                Text(
                    text = "Sample2",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate("sample3") }
            ) {
                Text(
                    text = "Sample3",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
                    .background(Color.Gray)
                    .clickable { navController.navigate("sample4") }
            ) {
                Text(
                    text = "Sample4",
                    fontSize = 18.sp
                )
            }
        }
    }
}

