package br.com.selfbot.mobile.android.feature.chat.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import com.example.downloadmedia.R

/**
 * Created by hugo on 27/05/2024.
 */
@Composable
fun ContentMediaView() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(40.dp)
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
                .padding(start = 10.dp)
                .size(30.dp)
                .clickable {  }
        )
        Text(
            text = "MANUAL-SELFBOT.pdf",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 5.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_media_download),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 0.dp)
                .size(30.dp)
                .clickable {  }
        )
    }
    Spacer(modifier = Modifier.padding(bottom = 8.dp))
}