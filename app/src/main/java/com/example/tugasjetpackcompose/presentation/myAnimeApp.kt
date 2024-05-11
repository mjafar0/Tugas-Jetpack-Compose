package com.example.tugasjetpackcompose.presentation

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.navigation.NavigationItem
import com.example.tugasjetpackcompose.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myAnimeApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
//    title: String,
//    showButton: Boolean,
//    backPress: () -> Unit
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: Screen.Home.route
    val currentScreen = remember(currentRoute) {
        Screen.fromRoute(currentRoute)
    }

    Scaffold(
        topBar = {

            TopAppBar(

                navigationIcon = {
                    if (currentScreen == Screen.Detail ||
                        currentScreen == Screen.Detail2||
                        currentScreen == Screen.About
                        )
                                 IconButton(onClick = { navController.navigateUp() }) {
                                     Icon(imageVector = Icons.Default.ArrowBackIosNew,
                                         contentDescription = stringResource(id = R.string.menu_home))
                                 }
                },

                modifier = Modifier
                    .background(color = Color.Red),
                title = { Text(text = currentScreen.title,
                    fontWeight = (FontWeight.Bold),
                    fontSize = 25.sp,
                    modifier = Modifier
                        ,
                    color = Color.White
                ) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.DarkGray),
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.About.route)}) {
                        Icon(imageVector = Icons.Default.AccountCircle,
                            contentDescription = stringResource(
                            id = R.string.menu_profile),
                            tint = Color.White
                        )
                    }
                },

                )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {contentPadding ->

        Text(
            text = "Judul",
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        NavHost(navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding))
        {

            composable(Screen.Home.route){

                HomeScreen(navController)
            }
            composable(Screen.Gallery.route) {

                myAnimeList()
            }
            composable(Screen.About.route) {
                aboutMe()
            }

            composable(
                Screen.Detail.route + "/{animeId}",
                arguments = listOf(navArgument("animeId") { type = NavType.IntType})
            ) {navBackStackEntry ->
                DetailScreen(modifier = modifier,
                    navController = navController,
                    animeId = navBackStackEntry.arguments?.getInt("animeId") )
            }

            composable(
                Screen.Detail2.route + "/{animeId2}",
                arguments = listOf(navArgument("animeId2") { type = NavType.IntType })
            ){navBackStackEntry ->
                DetailScreen2(navController = navController ,
                    modifier = modifier,
                    animeId2 = navBackStackEntry.arguments?.getInt("animeId2"))

            }

        }

    }

}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.inverseSurface,
) {
   NavigationBar(
       modifier = modifier,
       containerColor = containerColor,
   ) {
       val navBackStackEntry by navController.currentBackStackEntryAsState()
       val currentRoute = navBackStackEntry?.destination?.route

       val navigationItems = listOf(
           NavigationItem(
               title = stringResource(id = R.string.menu_home),
               icon = Icons.Default.Home,
               screen = Screen.Home
           ),
           NavigationItem(
               title = stringResource(id = R.string.menu_gallery),
               icon = Icons.Default.PlayArrow,
               screen = Screen.Gallery
           ),
           NavigationItem(
               title = stringResource(id = R.string.menu_profile),
               icon = Icons.Default.AccountCircle,
               screen = Screen.About
           )
       )

       navigationItems.map { item ->
           NavigationBarItem(
               selected = currentRoute == item.screen.route,
               onClick = {
                         navController.navigate(item.screen.route) {
                             popUpTo(navController.graph.findStartDestination().id) {
                                 saveState = true
                             }
                             restoreState = true
                             launchSingleTop = true
                         }
               }, icon = { Icon(imageVector = item.icon, contentDescription = item.title,
                   tint = if (currentRoute == item.screen.route) Color.DarkGray else Color.White) },
               label = { Text(
                   text = item.title,
                   color = if (currentRoute == item.screen.route) Color.Gray else Color.White
                    )
               }
           )
       }
   }
}

@Preview(showBackground = true)
@Composable
private fun myAnimeAppPreview() {
    myAnimeApp()
}