//package com.example.tugasjetpackcompose
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.tugasjetpackcompose.model.bAnime
//import com.example.tugasjetpackcompose.model.nAnime
//import com.example.tugasjetpackcompose.presentation.component.batchAnimeItem
//import com.example.tugasjetpackcompose.presentation.component.newAnimeItem
//import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            TugasJetpackComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Androidss")
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Apa Coba $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TugasJetpackComposeTheme {
//        Greeting("Android")
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//private fun NewAnimeItemPreview(){
//    TugasJetpackComposeTheme {
//        newAnimeItem(newAnime = nAnime(id = 1, name = "Captain Tsubasa Season 2: Junior Youth-Hen", status = "Ongoing" ,  genre = "Sport", R.drawable.ctsubasa))
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun batchAnimePreview() {
//    TugasJetpackComposeTheme {
//        batchAnimeItem(batch = bAnime(
//            id = 1,
//            name = "Mashle Season 2 Episode 1-12 [Batch]",
//            genre = "Action, Comedy",
//            status = "Complete",
//            sinopsis = "",
//            poster = R.drawable.mashle1
//        )
//        )
//    }
//}