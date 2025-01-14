package c3_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Modifier: alpha
// Модификатор alpha позволяет задавать прозрачность компонента.
// Параметры:
// - alpha: Float – уровень прозрачности от 0f (полностью прозрачный) до 1f (полностью непрозрачный) (обязательный).

@Composable
fun AlphaExample(){
    Spacer(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Magenta)
            .alpha(0.5f) // Установка прозрачности 50%
    )
}
