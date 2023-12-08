package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeProjectTheme {
//                VkNewsCard()
//            }
            Test()
        }
    }
}

@Composable
@Preview
fun Test() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Example3()
    }
}

@Composable
private fun Example1() {
    OutlinedButton(
        shape = RoundedCornerShape(4.dp),
        onClick = { /*TODO*/ }) {
        Text(text = "Hello world")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Example2() {
//    var text by rememberSaveable { mutableStateOf("Value") }
    TextField(
        value = "Value",
        onValueChange = { },
        label = { Text(text = "Label") }
    )
}

@Composable
private fun Example3() {
//    val openDialog = remember { mutableStateOf(true) }
//    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                /*TODO*/
//                openDialog.value = false
            },
            title = {
                Text(text = "Are you sure?")
            },
            text = {
                Text(text = "Do you want to delete this file?")
            },
            confirmButton = {
                TextButton(onClick = {
                    /*TODO*/
//                    openDialog.value = false
                }) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    /*TODO*/
//                    openDialog.value = false
                }) {
                    Text(text = "No")
                }
            }
        )
//    }

}