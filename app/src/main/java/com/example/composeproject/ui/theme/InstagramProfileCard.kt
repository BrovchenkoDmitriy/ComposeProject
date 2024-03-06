package com.example.composeproject.ui.theme

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.R

@Composable
fun InstagramProfileCard(viewModel: VkNewsMainScreenViewModel) {
    Log.d("State", "InstagramProfileCard")
    val isFollowed = viewModel.isFollowing.observeAsState(false)
    Card(
        shape = RoundedCornerShape(
            topStart = 4.dp,
            topEnd = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        modifier = Modifier.padding(4.dp)
    ) {
        Log.d("State", "Card")
        Column {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    InstagramLogo()
                }
                UserStatistics("7.000", "Posts")
                UserStatistics("8.000", "Followers")
                UserStatistics("9.000", "Following")
            }
            Text(
                text = "Instagram",
                fontFamily = FontFamily.Cursive,
                fontSize = 32.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            ContactInfo(value = "#YoursToMake")
            ContactInfo(value = "www.facebook.com/emotional_health")
            FollowButton(isFollowed = isFollowed) {
                viewModel.changeFollowStatus()
            }
        }
    }
}

@Composable
private fun ContactInfo(value: String) {
    Text(
        text = value,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 16.dp)
    )
}

@Composable
private fun FollowButton(isFollowed: State<Boolean>, clickListener: () -> Unit) {
    Log.d("State", "FollowButton")
    Button(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp),
        shape = RoundedCornerShape(4.dp),
        onClick = { clickListener() },
        colors = if (isFollowed.value) {
            ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(0.5f))
        } else {
            ButtonDefaults.buttonColors()
        }

    ) {
        Text(
            text = if (isFollowed.value) "Unfollow"
            else "Follow"
        )
    }
}

@Composable
private fun UserStatistics(value: String, description: String) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Cursive
            )
        }
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = description,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun InstagramLogo() {
    Image(
        modifier = Modifier
            .size(60.dp)
            .background(MaterialTheme.colorScheme.background)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.onBackground)
            .padding(1.dp)
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

//@Preview
//@Composable
//fun Dark() {
//    ComposeProjectTheme(
//        darkTheme = true
//    ) {
//        InstagramProfileCard()
//    }
//}