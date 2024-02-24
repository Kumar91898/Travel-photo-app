package com.example.travelphotoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelphotoapp.ui.theme.TravelPhotoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelPhotoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    val images = listOf(
        painterResource(R.drawable.pic0),
        painterResource(R.drawable.pic1),
        painterResource(R.drawable.pic2),
        painterResource(R.drawable.pic3),
        painterResource(R.drawable.pic4)
    )
    var currentImage by remember {
        mutableIntStateOf(0)
    }

    val places = listOf(
        "Qutub Minar", "Taj Mahal", "Burj Khalifa", "Eiffel Tower", "Leaning Tower"
    )

    var currentPlace by remember {
        mutableStateOf(places[currentImage])
    }

    Column {
        Text(
            text = "Travel Photo App\n\nTop places to visit",
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(start = 80.dp, top = 20.dp)
        )

        Box (
            modifier = Modifier
                .padding(top = 90.dp)
        ){
            Image(
                painter = images[currentImage],
                contentDescription = null,
                modifier = Modifier
                    .width(370.dp)
                    .padding(start = 15.dp, top = 30.dp)
            )
        }

        Row (
            modifier = Modifier
                .padding(start = 28.dp, top = 50.dp)
        ){
            Button(
                onClick = {
                    currentImage = (currentImage - 1 + images.size) % images.size
                    currentPlace = places[currentImage]
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {
                    currentImage = (currentImage + 1) % images.size
                    currentPlace = places[currentImage]
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(text = "Next")
            }
        }

        Text(
            text = currentPlace,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .padding(start = 90.dp, top = 80.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelPhotoAppTheme {
        Main()
    }
}