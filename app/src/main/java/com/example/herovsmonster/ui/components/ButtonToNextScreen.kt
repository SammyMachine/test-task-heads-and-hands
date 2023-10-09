package com.example.herovsmonster.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DrawButtonToNextScreen(text: String, navController: NavController, route: String, validInput: Boolean) {
    Button(
        onClick = {
            if (validInput) navController.navigate(route)
        },
        modifier = Modifier.size(250.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(84, 66, 60)
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 25.sp,
                color = Color(254, 200, 145),
                drawStyle = Stroke(
                    width = 6f,
                    miter = 1f,
                    join = StrokeJoin.Round
                ),
                letterSpacing = 1.sp
            )
        )
    }
}
