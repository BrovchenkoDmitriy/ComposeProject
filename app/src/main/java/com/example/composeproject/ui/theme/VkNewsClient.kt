package com.example.composeproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                text = "Просто обычный текст, не несущий смысловой нагрузки и предназначенный для теста.",
                modifier = Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                contentDescription = "Content",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
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
        TittleAndTime(tittle = "уволено", time = "14:00")
        Spacer(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        MenuButton()
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
        contentDescription = "Instagram_logo",
        contentScale = ContentScale.Inside,

        )
}

@Composable
private fun TittleAndTime(tittle: String, time: String) {
    Box(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = tittle,
                fontWeight = FontWeight.SemiBold
            )
            Text(text = time)
        }
    }
}

@Composable
private fun MenuButton() {
    IconButton(
        onClick = { /*TODO*/ },
        content = {
            MenuICon()
        }
    )
}

@Composable
private fun MenuICon() {
    Icon(
        painter = painterResource(R.drawable.ic_stat_name),
        contentDescription = "menu"
    )
}


