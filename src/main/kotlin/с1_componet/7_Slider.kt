package с1_componet
import androidx.compose.material.Slider
import androidx.compose.runtime.*

// Компонент: Slider
// Параметры:
// - value: Float – текущее значение ползунка (обязательный).
// - onValueChange: (Float) -> Unit – функция при изменении значения (обязательный).
// - valueRange: ClosedFloatingPointRange<Float> = 0f..1f – диапазон значений.
// - steps: Int = 0 – количество промежуточных шагов.
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - onValueChangeFinished: () -> Unit = {} – действие после завершения изменения значения.

@Composable
fun ExampleSlider() {
    var sliderValue by remember { mutableStateOf(0f) }
    Slider(
        value = sliderValue,
        onValueChange = { sliderValue = it }
    )
}