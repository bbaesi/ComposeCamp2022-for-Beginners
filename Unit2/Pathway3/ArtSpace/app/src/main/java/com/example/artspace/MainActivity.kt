package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                Surface()
                {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

val imageList = arrayListOf(R.drawable.lemon_tree, R.drawable.lemon_squeeze,
    R.drawable.lemon_drink, R.drawable.lemon_restart)
val nameList = arrayListOf(R.string.name1,R.string.name2,R.string.name3,R.string.name4)
val titleList = arrayListOf(R.string.content_Lemontree,R.string.content_Lemon,
    R.string.content_Glassoflemonade, R.string.content_Emptyglass)
val yearlist = arrayListOf("(2019)", "(2020)", "(2021)", "(2022)")

@Composable
fun ArtSpaceScreen() {
    var imageResource by remember { mutableStateOf(R.drawable.lemon_tree)}
    var nameResource by remember { mutableStateOf(R.string.name1)}
    var titleResource by remember { mutableStateOf(R.string.content_Lemontree)}
    var count by remember { mutableStateOf(0)}

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .fillMaxHeight(),
    )
    {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .weight(7F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ArtImageField(imageResource, nameList[count])
        }

        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .weight(1F)
                .shadow(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(Modifier.weight(1F))
            ArtTextField(titleResource, 24)
            ArtTextField(nameResource, 16, FontWeight.Bold, year = yearlist[count])
            Spacer(Modifier.weight(1F))
        }
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .weight(1F),
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                Modifier.weight(1F),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if(count==0) count = 3
                        else count --
                        imageResource = imageList[count]
                        titleResource = titleList[count]
                        nameResource = nameList[count] },
                    modifier = Modifier
                        .width(120.dp),

                    ) {
                    Text(text = "Previous")
                }
            }
            Column(
                Modifier.weight(1F),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom
            ) {
                Button(
                    onClick = {
                        if(count==3) count = 0
                        else count++
                        imageResource = imageList[count]
                        titleResource = titleList[count]
                        nameResource = nameList[count] },
                    modifier = Modifier
                        .width(120.dp)
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun ArtTextField(
    @StringRes txt : Int,
    size : Int,
    fontWeight  : FontWeight = FontWeight.Normal,
    year : String = ""
){
    Row {
        Text(
            text = stringResource(id = txt),
            fontSize = size.sp,
            fontWeight = fontWeight
        )
        if(year.isNotEmpty()){
            Text(
                text = year,
                fontSize = size.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun ArtImageField(
    @DrawableRes imageResource: Int,
    @StringRes content : Int
){
    Box(
        modifier = Modifier
            .shadow(1.dp)
            .border(
                width = 3.dp,
                color = Color.DarkGray,
                shape = RectangleShape
            )

    ){
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id=content),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}