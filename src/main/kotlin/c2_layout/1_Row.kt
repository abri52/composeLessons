package c2_layout

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/*
     Row это компонуемый контейнер,
     который располагает свои дочерние элементы горизонтально друг за другом.
     Он полезен для создания горизонтальных списков,
     меню, панелей инструментов и других элементов интерфейса,
     где требуется выстраивание компонентов в линию слева направо
     (или справа налево, в зависимости от настроек локали).
 */

// Параметры:
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - horizontalArrangement: Arrangement.Horizontal = Arrangement.Start – горизонтальное расположение элементов.
// - verticalAlignment: Alignment.Vertical = Alignment.Top – вертикальное выравнивание элементов.
// - content: @Composable RowScope.() -> Unit – содержимое строки.

@Composable
fun ExampleRow() {
    Row {
        Text("Элемент A")
        Text("Элемент B")
    }
}
