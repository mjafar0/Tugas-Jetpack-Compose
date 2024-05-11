package com.example.tugasjetpackcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tugasjetpackcompose.data.Data
import com.example.tugasjetpackcompose.model.mAnime
import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme

@Composable
fun myAnimeList(
    watch:List<mAnime> = Data.myAnime,
    modifier: Modifier = Modifier,
) {
    Column {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier,
                text = "Watching List",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(160.dp),
            verticalItemSpacing = 13.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.fillMaxSize()
        ) {
            items(watch, key = { it.id }) {

                Column(
                    modifier = Modifier
                ) {

                    Image(
                        painter = painterResource(id = it.poster),
                        contentDescription = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                        Text(
                            modifier = modifier
                            ,
                            text = it.name,
                            textAlign = TextAlign.Center
                        )
                    Row {

                        Text(text = "Status : ", fontSize = 12.sp)

                        Text(
                            modifier = Modifier,
                            text = it.status,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 12.sp
                        )
                    }



                }


            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun myAnimeListPrev(){
    TugasJetpackComposeTheme {
        myAnimeList(watch = Data.myAnime)
    }
}