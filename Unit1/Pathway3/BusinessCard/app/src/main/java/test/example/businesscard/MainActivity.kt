package test.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import test.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0, 58, 74)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
    ) {
        BusinessCardTopBox(Modifier.weight(1f))
        BusinessCardBottomBox(Modifier.weight(0.5f))
    }
}

@Composable
fun BusinessCardTopBox(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(75.dp, 75.dp),
            )
        Text(
            text = stringResource(R.string.myName),
            color = Color.White,
            fontWeight =FontWeight.Bold,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.myJob),
            color = Color(60,197,142),
            fontSize = 20.sp,
            fontWeight =FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun BusinessCardBottomBox(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(bottom = 40.dp)
    ) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(Color(50,94,107)))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(26.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.phone_call),
            contentDescription = "phone number",
            modifier = Modifier
                .size(25.dp, 25.dp)
                .weight(0.5f)
                .padding(start = 50.dp, top = 1.dp, bottom = 1.dp)
        )
        Text(
            text = stringResource(R.string.myPhoneNumber),
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .weight(1f)
        )
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(Color(50,94,107)))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.share),
            contentDescription = "sns",
            modifier = Modifier
                .size(25.dp, 25.dp)
                .weight(0.5f)
                .padding(start = 50.dp, top = 1.dp, bottom = 1.dp)
        )
        Text(
            text = stringResource(R.string.mySNS),
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .weight(1f)

        )
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(2.dp)
        .background(Color(50,94,107)))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.email),
            contentDescription = "email",
            modifier = Modifier
                .weight(0.5f)
                .size(25.dp, 25.dp)
                .padding(start = 50.dp, top = 1.dp, bottom = 1.dp)
        )
        Text(
            text = stringResource(R.string.myEmail),
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .weight(1f)
        )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0, 58, 74)
        ) {
            BusinessCard()
        }
    }
}