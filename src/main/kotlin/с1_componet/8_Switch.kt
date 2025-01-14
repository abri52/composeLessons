package с1_componet

import androidx.compose.material.Switch
import androidx.compose.runtime.*

// Компонент: Switch
// Параметры:
// - checked: Boolean – состояние переключателя (обязательный).
// - onCheckedChange: (Boolean) -> Unit – функция при изменении состояния (обязательный).
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - enabled: Boolean = true – возможность взаимодействия с переключателем.
// - colors: SwitchColors = SwitchDefaults.colors() – цвета переключателя.

@Composable
fun ExampleSwitch() {
    var switchState by remember { mutableStateOf(false) }
    Switch(
        checked = switchState,
        onCheckedChange = { switchState = it }
    )
}
