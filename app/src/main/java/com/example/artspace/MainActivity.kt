package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

//comment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowPage()
                }
            }
        }
    }
}


@Composable
fun ShowPage(){
    var imageSource by remember {
        mutableStateOf(1)
    }

    val painterResource = when(imageSource){
        1->R.drawable.github
        2->R.drawable.facebook
        3->R.drawable.whatsapp
        else->R.drawable.youtube
    }
    val stringResource = when(imageSource){
        1->R.string.github_icon
        2->R.string.facebook_icon
        3->R.string.whatsapp_icon
        else->R.string.youtube_icon
    }

    fun increase(){
        imageSource ++
        if (imageSource==5){
            imageSource = 1
        }
    }
    fun decrease(){
        imageSource --
        if (imageSource == 0){
            imageSource = 4
        }
    }

    val stringResource2 = when(imageSource){
        1->R.string.by_github_year
        2->R.string.by_facebook_year
        3->R.string.by_whatsapp_year
        else->R.string.by_youtube_year
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Image(painter = painterResource(id = painterResource),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(305.dp)
                .height(355.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = stringResource(id = stringResource),
            modifier = Modifier.padding(4.dp),
            textAlign = TextAlign.Center)
        Text(text = stringResource(id = stringResource2),
            modifier = Modifier.padding(4.dp)
        )

    }

    Row (
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(45.dp)
    ){
        Button(onClick = { decrease()},
            modifier = Modifier
        ) {
            Text(text = "Previous" , fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.width(14.dp))
        Button(onClick = { increase() },
            modifier = Modifier
        ) {
            Text(text = "Next" , fontSize = 25.sp)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ShowPage()
    }
}