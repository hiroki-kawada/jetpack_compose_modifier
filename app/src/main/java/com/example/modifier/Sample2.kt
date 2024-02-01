package com.example.modifier

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun Sample2(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
            ) {
                Text(
                    text = "アイテム1",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
            ) {
                Text(
                    text = "アイテム2",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
            ) {
                Text(
                    text = "アイテム3",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
            ) {
                Text(
                    text = "アイテム4",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = modifier
            ) {
                Text(
                    text = "アイテム5",
                    fontSize = 18.sp
                )
            }
        }
    }

}
