package com.example.herovsmonster.ui.components.start

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herovsmonster.ui.screens.StartViewModel

@Composable
fun DrawModifiers(startViewModel: StartViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Spacer(modifier = Modifier.width(30.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(28.dp))
            Row { DrawModifierTitle("Attack") }

            Spacer(modifier = Modifier.height(52.dp))
            Row { DrawModifierTitle("Defence") }

            Spacer(modifier = Modifier.height(52.dp))
            Row { DrawModifierTitle("Health") }

            Spacer(modifier = Modifier.height(52.dp))
            Row { DrawModifierTitle("DamageMin") }

            Spacer(modifier = Modifier.height(52.dp))
            Row { DrawModifierTitle("DamageMax") }
        }
        Spacer(modifier = Modifier.width(30.dp))
        Column(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(10.dp))
            DrawModifierField(0, startViewModel::updateList)

            Spacer(modifier = Modifier.height(10.dp))
            DrawModifierField(1, startViewModel::updateList)

            Spacer(modifier = Modifier.height(10.dp))
            DrawModifierField(2, startViewModel::updateList)

            Spacer(modifier = Modifier.height(10.dp))
            DrawModifierField(3, startViewModel::updateList)

            Spacer(modifier = Modifier.height(10.dp))
            DrawModifierField(4, startViewModel::updateList)
        }

    }
}

@Composable
fun DrawModifierTitle(text: String) {
    Text(
        text = when (text) {
            "Health" -> "Health"
            "DamageMin" -> "Minimum damage"
            "DamageMax" -> "Maximum damage"
            else -> "$text"
        },
        style = TextStyle(
            fontSize = 19.sp,
            color = Color(84, 66, 60),
            drawStyle = Stroke(
                width = 5f,
                miter = 1f,
                join = StrokeJoin.Round
            ),
            letterSpacing = 1.sp
        )
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DrawModifierField(
    pos: Int,
    updateList: (Int, String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = text,
        onValueChange = {
            val newText = it.filter { char -> char.isDigit() }
            text = newText
            updateList(pos, it)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }
        ),
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Blue, RoundedCornerShape(4.dp))
            .padding(8.dp)
            .fillMaxWidth()
    )
}
