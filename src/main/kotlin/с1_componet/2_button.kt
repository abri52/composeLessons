package с1_componet

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

// Компонент: Button
// Параметры:
// - onClick: () -> Unit – действие при нажатии (обязательный).
// - enabled: Boolean = true – возможность взаимодействия с кнопкой.
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - colors: ButtonColors = ButtonDefaults.buttonColors() – цвета кнопки.
// - contentPadding: PaddingValues = ButtonDefaults.ContentPadding – отступы содержимого.
// - shape: Shape = MaterialTheme.shapes.small – форма кнопки.

@Composable
fun ExampleButton() {
    Button(onClick = { /* Действие при нажатии */ }) {
        Text("Нажми меня")
    }
}