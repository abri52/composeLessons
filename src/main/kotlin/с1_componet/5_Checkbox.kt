package с1_componet

import androidx.compose.material.Checkbox
import androidx.compose.runtime.*

// Компонент: Checkbox
// Параметры:
// - checked: Boolean – состояние флажка (обязательный).
// - onCheckedChange: (Boolean) -> Unit – функция при изменении состояния (обязательный).
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - enabled: Boolean = true – возможность взаимодействия с флажком.
// - colors: CheckboxColors = CheckboxDefaults.colors() – цвета флажка.

@Composable
fun ExampleCheckbox() {
    var isChecked by remember { mutableStateOf(false) }
    Checkbox(
        checked = isChecked,
        onCheckedChange = { isChecked = it }
    )
}
