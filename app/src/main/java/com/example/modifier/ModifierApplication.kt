package com.example.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModifierApplication(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        content = { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                NavHost(navController = navController, startDestination = "list") {
                    //リスト画面
                    composable("list") {
                        List(
                            navController = navController,
                            modifier = modifier
                        )
                    }
                    // アイテムそれぞれにデザイン適用する場合のサンプルリスト
                    composable("sample1") {
                        Sample1()
                    }
                    // アイテム全て同じデザイン適用する場合のサンプルリスト
                    composable("sample2") {
                        Sample2(
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth()
                                .padding(bottom = 1.dp)
                                .background(Color.Gray)
                        )
                    }
                    // 順序が異なるアイテムを配置する場合のサンプルリスト
                    composable("sample3") {
                        Sample3()
                    }
                    // 表示、非表示サンプルサンプルリスト
                    composable("sample4") {
                        Sample4()
                    }
                }


            }
        })
}
