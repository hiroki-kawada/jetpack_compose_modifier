package com.example.modifier

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sample3(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier =
                modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .background(Color.Blue)
            ) {
                Text(
                    text = "アイテム1_padding → background",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier =
                modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .padding(20.dp)
            ) {
                Text(
                    text = "アイテム1_background → padding",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier =
                modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
                    .background(Color.Magenta,
                        shape = RoundedCornerShape(20.dp))
            ) {
                Text(
                    text = "アイテム2_border → padding",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier =
                modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .border(
                        width = 2.dp,
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(Color.Magenta,
                        shape = RoundedCornerShape(20.dp))
            ) {
                Text(
                    text = "アイテム2_padding → border",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier =
                modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .clickable { Log.d("Sample3", "アイテム3押下") }
                    .padding(20.dp)
            ) {
                Text(
                    text = "アイテム3_clickable → padding",
                    fontSize = 18.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier =
                modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(20.dp)
                    .clickable { Log.d("Sample3", "アイテム3押下") }
            ) {
                Text(
                    text = "アイテム3_padding → clickable",
                    fontSize = 18.sp
                )
            }
        }
    }
}