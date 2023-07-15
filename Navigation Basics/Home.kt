package com.example.jetpackcompose.ui

import android.graphics.Paint.Align
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController? = null) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)) {
        TextField(value = "", onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            shape = RoundedCornerShape(5.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, "This is search icon")
            }
        )
        TitleText(title = "My Tasks")

        LazyColumn {
            var i = 0
            items((0..4).toList()){
                TaskCard("Item ${++i}", navController)
            }
        }
    }
}

@Composable
fun TaskCard(task: String, navController: NavController? = null) {
    ElevatedCard (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(top = 8.dp)
            .clickable {
                navController?.navigate("task")
            }
            ){
        Row(modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.baseline_rocket_launch_24), contentDescription = "")
            Text(text = task, fontSize = 28.sp)
        }
    }
}

@Composable
fun TitleText(title: String){
    Text(text = title, fontSize = 32.sp)
}
