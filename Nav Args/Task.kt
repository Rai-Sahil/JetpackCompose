package com.example.jetpackcompose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Task(navController: NavController? = null, item: String? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        if (item != null) TitleText(title = item) else TitleText(title = "Task Detail")

        LazyColumn (modifier = Modifier.clickable {
            navController?.navigate("task")
        }){
            var i = 0
            items((0..5).toList()){
                TaskCard("Detail Item ${++i}")
            }
        }
    }
}
