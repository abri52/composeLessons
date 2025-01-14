package c2_layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


/*

    Column — это компонуемый контейнер,
    который располагает свои дочерние элементы вертикально друг под другом.
    Он широко используется для создания вертикальных списков, форм,
    вертикальных меню и других интерфейсных структур,
    где требуется выстраивание компонентов сверху вниз.

 */


// Параметры:
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - verticalArrangement: Arrangement.Vertical = Arrangement.Top – вертикальное расположение элементов.
// - horizontalAlignment: Alignment.Horizontal = Alignment.Start – горизонтальное выравнивание элементов.
// - content: @Composable ColumnScope.() -> Unit – содержимое колонки.

@Composable
fun ExampleColumn() {
    Column {
        Text("Элемент 1")
        Text("Элемент 2")
    }
}
