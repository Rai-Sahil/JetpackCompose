package com.example.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }
    }
}

data class User (val name: String)

val user = listOf(
    User("Sahil"),
    User("John"),
    User("Aryan"),
    User("Joe"),
    User("Jane"),
    User("Rai"),
    User("Name")
)

@Composable
fun UserList() {
//    Column (modifier = Modifier.verticalScroll(state = rememberScrollState())){
//        for (i in 1..10){
//            UserCard()
//        }
//    }

    //Only render things currently in view just like recyclerview
    LazyColumn{
        items(user){
            UserCard(it.name)
        }
    }
}

@Composable
fun UserCard(name: String) {
    val context = LocalContext.current
    //Just like horizontal layout
    ElevatedCard(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_rocket_launch_24),
                contentDescription = "This is test image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Column {
                Text(text = name)
                Button(onClick = {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //I only wanna wanna preview the surface but not show it
    Surface (Modifier.fillMaxSize()){
        UserList()
    }
}

