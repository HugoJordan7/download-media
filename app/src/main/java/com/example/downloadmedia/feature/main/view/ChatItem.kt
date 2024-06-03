package br.com.selfbot.mobile.android.feature.chat.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.downloadmedia.R

@Composable
fun ChatItem() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(2.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(
                        RoundedCornerShape(
                            topStart = 32f,
                            topEnd = 32f,
                            bottomStart = 0f,
                            bottomEnd = 32f
                        )
                    )
                    .background(colorResource(id = R.color.purple_500))
                    .padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp,
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                ) {
                    ContentMediaView()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewChatItem(){
    Surface(
        modifier =  Modifier.fillMaxSize()
    ) {
        ChatItem()
    }
}