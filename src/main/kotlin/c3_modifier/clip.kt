package c3_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Modifier: clip
// Модификатор clip позволяет обрезать содержимое компонента по заданной форме.
// Параметры:
// - shape: Shape – форма для обрезки содержимого (обязательный).
//
// Пример округления углов с помощью RoundedCornerShape.

@Composable
fun ClipExample(){
    Spacer(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan)
            .clip(RoundedCornerShape(16.dp)) // Округление углов радиусом 16.dp
    )
}
