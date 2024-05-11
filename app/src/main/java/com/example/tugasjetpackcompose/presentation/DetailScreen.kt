package com.example.tugasjetpackcompose.presentation

import android.telecom.Call.Details
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.IconButton
import coil.request.ImageRequest
import com.example.tugasjetpackcompose.data.Data
import com.example.tugasjetpackcompose.model.bAnime
import com.example.tugasjetpackcompose.model.nAnime

@Composable
fun DetailScreen(
    modifier: Modifier,
    navController: NavController,
    animeId: Int?
) {
    val detaiList = Data.newAnime.filter { new ->
        new.id == animeId
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        DetailCards(detailList = detaiList)
    }
}

@Composable
private fun DetailCards(
   detailList: List<nAnime>,
   modifier: Modifier = Modifier
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            ,
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = detailList[0].poster)
                .build()
            ,
            modifier = Modifier
                .size(350.dp),
            contentDescription = "Poster Movie"
            )
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            ) {

            Text(text = detailList[0].name,
                modifier = Modifier
                    ,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(top = 18.dp)
                    ,
                text = "Sinopsis:",
                fontSize = 20.sp,
                style = TextStyle(textAlign = TextAlign.Justify)

            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = detailList[0].sinopsis,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 12.dp),
            ){
                Text(text = detailList[0].status,
                    fontSize = 17.sp,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    modifier = Modifier,

                    text = "Genre: ${detailList[0].genre}",
                    fontSize = 17.sp,
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview(){
    DetailCards(detailList = Data.newAnime)
}