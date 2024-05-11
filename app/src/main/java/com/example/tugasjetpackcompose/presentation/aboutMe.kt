package com.example.tugasjetpackcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasjetpackcompose.R
import com.example.tugasjetpackcompose.model.pData
import com.example.tugasjetpackcompose.ui.theme.TugasJetpackComposeTheme

@Composable
fun aboutMe(
//    profileData:pData,
    modifier: Modifier = Modifier,
){
    Image(painter = painterResource(id = R.drawable.profilbg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)

        ){
        Image(painter = painterResource(id = R.drawable.mj2),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .background(color = Color.White, CircleShape)
            ,

            )
            Text( modifier = Modifier
                .padding(top = 20.dp)
                ,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                text = "Muhammad Jafar",
//                text = profileData.namaa

            )

            Text( modifier = Modifier

                ,
                fontSize = 20.sp,
                color = Color.White,
                text = "Teknik Informatika",
//                text = profileData.jurusan
            )

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 30.dp)
                ,
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(modifier = Modifier
                        ,
                        color = Color.White,
                        text = "1725",
//                        text = profileData.follower
                    )
                    Text(text = "Followers")
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(modifier = Modifier
                        ,
                        color = Color.White,
                        text = "27",
//                        text = profileData.following
                    )
                    Text(text = "Following")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(modifier = Modifier
                        ,
                        color = Color.White,
                        text = "125",
//                        text = profileData.watching
                    )
                    Text(text = "Watching")
                }
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 25.dp),
                thickness = 2.dp,
                color = Color.Black,
            )
            Card(
                modifier = modifier
                    .padding(10.dp)
                ,

            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth(),
                    ){

                        Image(painter = painterResource(id = R.drawable.email),
                            contentDescription =null,
                            modifier = Modifier
                                .size(40.dp),)
                        Text( modifier = Modifier
                            .padding(start = 20.dp)
                            ,
                            fontSize = 20.sp,
                            text = "mjafar070202@gmail.com",
//                            text = profileData.email,
                            color = MaterialTheme.colorScheme.primary
                            )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(),
                    ){

                        Image(painter = painterResource(id = R.drawable.ut),
                            contentDescription =null,
                            modifier = Modifier
                                .size(40.dp),)
                        Text( modifier = Modifier
                            .padding(start = 20.dp)
                            ,
                            fontSize = 15.sp,
                            color = MaterialTheme.colorScheme.primary,
                            text = "Sekolah Tinggi Teknologi Indonesia",
//                            text = profileData.asalpt
                        )
                    }

                }
            }

    }
}

@Preview(showBackground = true)
@Composable
private fun aboutMePrev(){
    TugasJetpackComposeTheme {
        aboutMe()
//        aboutMe(profileData = pData(
//            namaa = "Muhammad Jafar",
//            email = "mjafar070202@gmail.com",
//            asalpt = "Sekolah Tinggi Teknologi Indonesia",
//            jurusan = "Teknik Informatika",
//            foto = R.drawable.mj,
//            following = "27",
//            watching = "125",
//            follower = "1725",
//        ))
    }
}
