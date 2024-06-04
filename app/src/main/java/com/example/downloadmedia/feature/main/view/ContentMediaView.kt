package com.example.downloadmedia.feature.main.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.downloadmedia.R
import com.example.downloadmedia.feature.main.viewModel.MediaViewModel
import org.koin.androidx.compose.inject

@Composable
fun ContentMediaView() {
    val context: Context = LocalContext.current
    val viewModel: MediaViewModel by inject()
    val isFailure = viewModel.isFailure.collectAsState().value
    val isDownloading = viewModel.isDownloading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value
    if(isFailure){
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }
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
        if (!isDownloading){
            Image(
                painter = painterResource(id = R.drawable.ic_media_download),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp, end = 5.dp)
                    .size(30.dp)
                    .clickable {
                        viewModel.downloadMedia(
                            "https://www.ribeiraopreto.sp.gov.br/files/ssaude/pdf/og_acao_combate_m_aedes.pdf",
                            "Combate ao aedes.pdf",
                            context
                        )
                    }
            )
        } else{
            Toast.makeText(context, "Começando o download do arquivo!", Toast.LENGTH_SHORT).show()
            CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 3.dp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp, end = 5.dp)
                    .size(25.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 8.dp))
}