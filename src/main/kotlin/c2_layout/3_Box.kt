package c2_layout

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


/*

    Box — это компонуемый контейнер,
    который накладывает свои дочерние элементы друг на друга.
    Он полезен для создания наложений, фоновых изображений,
    всплывающих окон и других интерфейсных элементов,
    где требуется размещение компонентов в одном пространстве с возможностью их перекрытия.

 */


// Параметры:
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - contentAlignment: Alignment = Alignment.TopStart – выравнивание содержимого внутри Box.
// - content: @Composable () -> Unit – содержимое Box.

@Composable
fun ExampleBox() {
    Box {
        Text("Внутри Box")
    }
}
