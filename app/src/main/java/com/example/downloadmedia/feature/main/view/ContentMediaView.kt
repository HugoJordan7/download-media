package com.example.downloadmedia.feature.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.downloadmedia.R

@Composable
fun ContentMediaView() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth(0.65f)
            .background(
                color = Color(0xFF955FDB),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_file),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 5.dp, top = 5.dp, bottom = 5.dp)
                .size(30.dp)
                .clickable { }
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(160.dp)
                .padding(start = 5.dp)
        ) {
            Text(
                text = "Hugo.pdf",
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_media_download),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 10.dp, end = 5.dp)
                .size(30.dp)
                .clickable { }
        )
    }
    Spacer(modifier = Modifier.padding(bottom = 8.dp))
}