package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface()
                {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    var imageResource by remember { mutableStateOf(R.drawable.lemon_tree)} // 상태 변경 추적 및 저장

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    )
    {
        Column(
            modifier = Modifier
                .padding(10.dp),
        ) {
            ArtImageField(imageResource)
        }

        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
        ) {
            Text(
                text = "ArtWork Title",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "ArtWork Title",
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )        
        }
    }
}

@Composable
fun ArtButtonField(
){
    Column(

    ) {
        Button(onClick = { /*TODO*/ }) {
            Modifier
        }
    }
}


@Composable
fun ArtImageField(
    @DrawableRes imageResource: Int
){
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}