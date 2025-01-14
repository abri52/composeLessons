package с1_componet

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

// Компонент: Text
// Параметры:
// - text: String – текст для отображения (обязательный).
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - color: Color = Color.Unspecified – цвет текста.
// - fontSize: TextUnit = TextUnit.Unspecified – размер шрифта.
// - fontWeight: FontWeight? = null – толщина шрифта.
// - textAlign: TextAlign? = null – выравнивание текста.
// - maxLines: Int = Int.MAX_VALUE – максимальное количество строк.
// - overflow: TextOverflow = TextOverflow.Clip – поведение при переполнении текста.

@Composable
fun ExampleText() {
    Text("Привет, Compose!")
}