package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme{
                val image = painterResource(id = R.drawable.bg_compose_background)
                val modifier = Modifier
                ArticleCard(getString(R.string.title_jetpack_compose_tutorial),
                   getString(R.string.compose_short_desc),
                    getString(R.string.compose_long_desc),
                    image,
                    modifier)
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {}

/**
 * Compose Article UI 구현 메소드
 * @param title 제목
 * @param shortDescription 상단 설명
 * @param longDescription 하단 설명
 * @param imagePainter 최상단 그림
 * @param modifier 수정자
 */
@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column() {
        Image(painter = imagePainter,
            contentDescription = "상단 이미지",
            modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start))
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp, top=16.dp, bottom = 16.dp)
        )
        Text(
            text = shortDescription,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = longDescription,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top=16.dp, bottom = 16.dp),
            textAlign = TextAlign.Justify

        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme{
    }
}