package com.example.tugasjetpackcompose.presentation

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.data.Data
import com.example.tugasjetpackcompose.model.bAnime
import com.example.tugasjetpackcompose.model.nAnime
import com.example.tugasjetpackcompose.model.oAnime
import com.example.tugasjetpackcompose.navigation.NavigationItem
import com.example.tugasjetpackcompose.navigation.Screen
import com.example.tugasjetpackcompose.presentation.aboutMe
import com.example.tugasjetpackcompose.presentation.component.batchAnimeItem
import com.example.tugasjetpackcompose.presentation.component.newAnimeItem
import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    newAnimes: List<nAnime> = Data.newAnime,
    batchAnimes: List<bAnime> = Data.batchAnime
) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                ,
            ){
                Text(
                    modifier = Modifier
                        .padding(start = 7.dp, top = 10.dp),
                    text = "Anime Terbaru",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null
                )
            }

            LazyRow (
                contentPadding = PaddingValues(10.dp),
//                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = modifier
            ){
                items(newAnimes, key = { it.id }) {
                    newAnimeItem(newAnime = it) {animeId ->
                        navController.navigate(Screen.Detail.route + "/$animeId")
                    }
                }
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 20.dp)
                ,
            ){
                Text(
                    modifier = Modifier
                        .padding(start = 7.dp),
                    text = "Anime Batch",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.Default.ChevronRight, contentDescription = null
                )
            }

        }
        items(batchAnimes, key = { it.id }) {
            batchAnimeItem(batch = it) {animeId2 ->
                navController.navigate(Screen.Detail2.route + "/$animeId2")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev(){
    TugasJetpackComposeTheme {
        HomeScreen(navController = rememberNavController())
    }
}