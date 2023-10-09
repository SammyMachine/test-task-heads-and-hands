package com.example.herovsmonster.ui.components.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herovsmonster.ui.theme.customColorForText

@Composable
fun DrawTitle() {
    Column(
        Modifier
            .padding(top = 200.dp, start = 100.dp)
    ) {
        Text(
            text = "Slay the monster!",
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
