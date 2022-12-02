package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview
@Composable
fun LemonadeApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Preview(showBackground = true)
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // remember -> 객체를 메모리에 저장
    // mutableStateOf() 함수로 UI를 새로고침
    var result by remember { mutableStateOf(1) }
    var count : Int = (2..4).random()
    var ck : Int = 1
    var txt : Int
    var content : Int
    val imageResource : Int
    when(result) {
        1 -> {
            imageResource = R.drawable.lemon_tree
            txt = R.string.Lemontree
            content = R.string.content_Lemontree
        }
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            txt =R.string.Lemon
            content = R.string.content_Lemon
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            txt =R.string.Glassoflemonade
            content = R.string.content_Glassoflemonade
        }
        else -> {
            imageResource = R.drawable.lemon_restart
            txt =R.string.Emptyglass
            content = R.string.Emptyglass
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = txt),
            fontSize = 18.sp,
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = {
                if(result == 2) {
                    if(ck==count) result ++
                    else ck ++
                }
                else if (result == 4) {
                    result = 1
                    ck = 1
                }
                else result ++
            },
            Modifier.border(
                width = 4.dp,
                color = Color(105,205,216),
                shape = RoundedCornerShape(4.dp)
            ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        )
        {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = content.toString(),
            )
        }
    }
}
