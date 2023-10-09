package com.example.herovsmonster.ui.components.home

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
import com.example.herovsmonster.ui.navigation.Screen
import com.example.herovsmonster.ui.theme.customColorForText

@Composable
fun DrawButtonHome(text: String, navController: NavController) {
    Button(
        onClick = {
            when (text) {
                "Guide" -> navController.navigate(Screen.GuideScreen.route)
                "Start" -> navController.navigate(Screen.StartScreen.route)
            }
        },
        Modifier
            .size(250.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(255, 121, 46)
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 25.sp,
                color = customColorForText,
                drawStyle = Stroke(
                    width = 4f,
                    miter = 10f,
                    join = StrokeJoin.Round
                )
            )
        )
    }
}
