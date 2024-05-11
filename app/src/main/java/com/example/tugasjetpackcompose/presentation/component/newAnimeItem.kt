package com.example.tugasjetpackcompose.presentation.component

import android.content.res.Resources.Theme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.model.nAnime
import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme

@Composable
fun newAnimeItem(
    newAnime: nAnime,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {

    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = (15.dp))
            .width(150.dp)
            .clickable {
                       onItemClicked(newAnime.id)
            }
    ) {
        Image(
            painter = painterResource(id = newAnime.poster),
            contentDescription = newAnime.name, modifier = Modifier
                .clip(RectangleShape)
                .size(200.dp)
        )
        Text(
            modifier = Modifier
                .padding(5.dp)
                .width(165.dp)
                .padding(start = (2.dp))
            ,
            text = newAnime.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
//                modifier = Modifier.width(140.dp),
            maxLines = 2
        )
        Text(
            modifier = Modifier
                .padding(5.dp)
                .padding(start = (2.dp))
            ,
            text = newAnime.status,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun NewAnimeItemPreview(){
    TugasJetpackComposeTheme {
        newAnimeItem(newAnime = nAnime(id = 1, name = "Captain Tsubasa Season 2: Junior Youth-Hen", status = "Ongoing", genre = "Sport, School, Romance", sinopsis = "urnamen nasional sepak bola SMP berakhir dengan kemenangan SMP Nankatsu dan Akademi Toho secara bersamaan. Usai turnamen, Timnas Junior Jepang akan dipilih untuk mengikuti Turnamen Junior Internasional yang akan diselenggarakan di Paris, Perancis." ,poster = R.drawable.ctsubasa),
            onItemClicked = { anime2Id ->
                println("Anime Id: ${anime2Id}")
            })
    }
}
