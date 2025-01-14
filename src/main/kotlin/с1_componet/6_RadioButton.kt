package с1_componet

import androidx.compose.material.RadioButton
import androidx.compose.runtime.*

// Компонент: RadioButton
// Параметры:
// - selected: Boolean – выбран ли данный переключатель (обязательный).
// - onClick: () -> Unit – действие при нажатии (обязательный).
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - enabled: Boolean = true – возможность взаимодействия с переключателем.
// - colors: RadioButtonColors = RadioButtonDefaults.colors() – цвета переключателя.

@Composable
fun ExampleRadioButton() {
    var selected by remember { mutableStateOf(false) }
    RadioButton(
        selected = selected,
        onClick = { selected = !selected }
    )
}
