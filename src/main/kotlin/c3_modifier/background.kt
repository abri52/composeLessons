package c3_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Modifier: background
// Модификатор background позволяет задавать фон для компонента.
// Параметры:
// - color: Color – цвет фона (обязательный).
// - shape: Shape = RectangleShape – форма фона.
// - brush: Brush? = null – кисть для заливки фона.
// - alpha: Float = 1.0f – прозрачность фона.
//
// Примечание: Вы можете использовать либо `color`, либо `brush` для заливки фона.

@Composable
fun BackgroundExample(){
    Spacer(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Green) // Установка зелёного фона
    )
}
