package com.example.downloadmedia.feature.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.downloadmedia.ui.theme.DownloadMediaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DownloadMediaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatItem()
                }
            }
        }
    }

}

@Composable
fun CircularProgressTest(){
    DownloadMediaTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator(
                color = Color.Blue,
                strokeWidth = 2.dp,
                modifier = Modifier
                    .padding(start = 10.dp, end = 5.dp)
                    .size(30.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CircularProgressTest()
}