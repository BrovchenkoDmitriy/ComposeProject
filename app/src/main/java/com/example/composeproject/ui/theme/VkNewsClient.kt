package com.example.composeproject.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeproject.R

@Preview
@Composable
fun VkNewsCard() {
    Card(
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier.padding(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadOfVkNewsCard()
            Text(
                text = stringResource(R.string.template_text),
                modifier = Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.content),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            BottomMenuOfVkNewsCard()
        }
    }
}

@Composable
private fun HeadOfVkNewsCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        VkAvatar()
        Spacer(modifier = Modifier.width(4.dp))
        Column (
            modifier = Modifier.weight(1f)
        ){
            Text(text = "уволено")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "14:20")
        }
        MenuButton(Icons.Rounded.MoreVert)
    }
}

@Composable
private fun BottomMenuOfVkNewsCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomMenuButton("206", R.drawable.ic_views)
        Spacer(Modifier.weight(1f, true))
        BottomMenuButton("206", R.drawable.ic_share)
        BottomMenuButton("11", R.drawable.ic_comments)
        BottomMenuButton("491", R.drawable.ic_chosen)
    }
}

@Composable
private fun VkAvatar() {
    Image(
        modifier = Modifier
            .size(50.dp)
            .background(MaterialTheme.colorScheme.background)
            .clip(CircleShape)
            .paint
                (
                painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Inside,
            ),
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = stringResource(R.string.instagram_logo),
        contentScale = ContentScale.Inside,

        )
}

@Composable
private fun MenuButton(id: ImageVector) {
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            Icon(
                imageVector = id,
                contentDescription = stringResource(R.string.menu)
            )
        }
    )
}

@Composable
private fun BottomMenuButton(value: String, @DrawableRes id: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(0.dp)
    ) {
        Text(text = value)
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.wrapContentSize(),
        ) {
            Icon(

                painter = painterResource(id),
                contentDescription = stringResource(R.string.bottom_menu)
            )
        }
    }
}


