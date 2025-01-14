package с1_componet

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable

// Компонент: IconButton
// Параметры:
// - onClick: () -> Unit – действие при нажатии (обязательный).
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - enabled: Boolean = true – возможность взаимодействия с кнопкой.
// - colors: IconButtonColors = IconButtonDefaults.iconButtonColors() – цвета кнопки.

@Composable
fun ExampleIconButton() {
    IconButton(onClick = { /* Действие при нажатии */ }) {
        Icon(Icons.Default.Home, contentDescription = "Кнопка Домой")
    }
}
