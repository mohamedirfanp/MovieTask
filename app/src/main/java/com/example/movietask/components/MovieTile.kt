package com.example.movietask.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.movietask.models.Movie

@Composable
fun MovieTile(movie : Movie)
{
    Card(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize()

            .clickable { Log.d("OUTPUT", movie.imdbID.toString()) }
            .height(180.dp), shape = RoundedCornerShape(8.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row {
            Image(painter = rememberAsyncImagePainter(movie.Poster), contentDescription = "MoviePoster",
                modifier = Modifier.wrapContentSize().height(200.dp).padding(2.dp)
            )
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

                Text(text = "${movie.Title}", fontSize = 23.sp, fontWeight = FontWeight(500))
                Text(text = "Type : ${movie.Type}", fontSize = 20.sp, fontWeight = FontWeight(400))
                Text(text = "Year : ${movie.Year}", fontSize = 17.sp, fontWeight = FontWeight(400))
            }
        }
    }

}
