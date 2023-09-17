package com.example.nasacollection.ui.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nasacollection.domain.item.CollectionItem
import com.example.nasacollection.utils.TodayDate

@Composable
fun HomeScreen(){
    val viewmodel = viewModel(modelClass = HomeViewmodel::class.java)
    val collection by viewmodel.collection.collectAsState()
    val error by viewmodel.errorBody.collectAsState()

    when{
        collection.title == null && error.isEmpty() -> ShowLoadingScreen()
        error.isNotEmpty() -> ShowError(error = error)
        else -> ShowNasaContent(item = collection)
    }

}

@Composable
fun ShowError(error: List<String>){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "Error icon",
            modifier = Modifier
                .size(32.dp)
                .background(Color.White),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Oops... something is Wrong!",
            style = TextStyle(
                fontSize = 32.sp,
                color = Color.White
            ))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Please, restart the app, and check your network connection!",
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.White
            ))
    }
}

@Composable
fun ShowLoadingScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Loading...",
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.White
            ))
    }
}

@Composable
fun ShowNasaContent(item: CollectionItem){
    var showExplanation by remember { mutableStateOf(false) }

    Box(modifier =  Modifier.fillMaxSize(),
    ){
        val image = rememberImagePainter(data = item.url)

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize())

        Text(
            text = item.date.toString().TodayDate(),
            Modifier
                .zIndex(10f)
                .padding(16.dp)
                .align(Alignment.TopCenter),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
            ),
        )

        Column(
            Modifier
                .zIndex(10f)
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = item.title.toString(),
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                ),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.explanation.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    ),
                maxLines = if (!showExplanation) 2 else 25,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            ElevatedButton(modifier = Modifier
                .width(200.dp)
                .height(60.dp)
                .align(Alignment.End),
                onClick = { showExplanation = !showExplanation }){
                Text(text = "Read More")
            }
        }
    }
}