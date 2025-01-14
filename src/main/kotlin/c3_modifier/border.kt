package c3_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Modifier: border
// Модификатор border позволяет добавлять границу к компоненту.
// Параметры:
// - width: Dp – толщина границы (обязательный).
// - color: Color – цвет границы (обязательный).
// - shape: Shape = RectangleShape – форма границы.
//
// Пример добавления границы толщиной 2.dp и красного цвета.

@Composable
fun BorderExample(){
    Spacer(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .border(width = 2.dp, color = Color.Red) // Добавление красной границы толщиной 2.dp
    )
}
