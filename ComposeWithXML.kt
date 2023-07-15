package com.example.jetpackcompose

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithXML()
        }

    }
}

@Composable
fun ComposeWithXML() {
    AndroidView(
        factory = {
            View.inflate(it, R.layout.layout1, null)
        },
        modifier = Modifier.fillMaxSize(),
        update = {
            val textView = it.findViewById<TextView>(R.id.textView_layout1)
            textView.setOnClickListener {
                textView.text = "Clicked"
            }
        }
    )
}
