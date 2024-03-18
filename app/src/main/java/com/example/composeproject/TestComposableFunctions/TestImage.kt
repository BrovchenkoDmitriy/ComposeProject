package com.example.composeproject.TestComposableFunctions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeproject.R

@Preview
@Composable
fun TestImage() {
    Image(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Green)
        ,
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Instagram_logo",
        contentScale = ContentScale.Fit
    )
}