package com.example.tugasjetpackcompose.presentation.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.data.Data.batchAnime
import com.example.tugasjetpackcompose.model.bAnime
import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme

@Composable
fun batchAnimeItem(
    batch: bAnime,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit,
) {
    Card (
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal=10.dp)
        .clickable {
            onItemClicked(batch.id)
        },
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
            ,
        ) {
            Text(
                modifier = modifier
                    .padding(horizontal = 20.dp)
                ,
                textAlign = TextAlign.Center,
                text = batch.name,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .size(width = 100.dp, height = 240.dp)
                    .padding(vertical = 20.dp)
                ,
                painter = painterResource(id = batch.poster),
                contentDescription = batch.name,
            )
            Column {
//                Text(text = batch.name, style = MaterialTheme.typography.titleMedium)
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                    ,
                ) {
                    Text(
                        text = batch.status,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 12.sp
                    )

                    Text(
                        text = "Genre : ${batch.genre}",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun batchAnimePreview() {
    TugasJetpackComposeTheme {
        batchAnimeItem(batch = bAnime(
            id = 1,
            name = "Mashle Season 2 Episode 1-12 [Batch]",
            genre = "Action, Comedy",
            status = "Complete",
            sinopsis = "",
            poster = R.drawable.mashle1
        ),
            onItemClicked = { animeId ->
                println("Anime Id: $animeId")
            })
    }
}