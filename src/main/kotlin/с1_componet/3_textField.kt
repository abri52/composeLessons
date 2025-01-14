package с1_componet

import androidx.compose.material.TextField
import androidx.compose.runtime.*

// Компонент: TextField
// Параметры:
// - value: String – текущее значение поля (обязательный).
// - onValueChange: (String) -> Unit – функция при изменении текста (обязательный).
// - label: @Composable (() -> Unit)? = null – метка поля.
// - placeholder: @Composable (() -> Unit)? = null – заполнитель.
// - singleLine: Boolean = false – однострочный ввод.
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - colors: TextFieldColors = TextFieldDefaults.textFieldColors() – цвета поля.

@Composable
fun ExampleTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it }
    )
}
