package com.example.myapplication

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithImage(stringResource(id = R.string.happy_message),
                        stringResource(id = R.string.from_name))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String,name: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(painter = image,
            contentDescription = null,
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(), contentScale = ContentScale.Crop)
        BirthdayGreetingWithText(message = message, name = name)
    }
}

@Composable
fun BirthdayGreetingWithText (message: String,name: String) {
Column {
    Text(text = message,
        fontSize = 30.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.Start)
            .padding(start = 16.dp, top = 16.dp)
    )
    Text(text = name,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End)
            .wrapContentHeight(Alignment.Bottom)
            .padding(end = 16.dp, top = 16.dp))
}
}

@Preview(showBackground = false,
showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        BirthdayGreetingWithImage(stringResource(R.string.happy_message),
                    stringResource(R.string.from_name)
                )
    }
}