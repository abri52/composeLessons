package с1_componet

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable

// Компонент: Icon
// Параметры:
// - imageVector: ImageVector – векторная иконка (обязательный).
// - contentDescription: String? – описание для доступности.
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current) – цвет иконки.

@Composable
fun ExampleIcon() {
    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = "Домашняя иконка"
    )
}
