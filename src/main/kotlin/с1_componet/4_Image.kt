package с1_componet

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

// Компонент: Image
// Параметры:
// - painter: Painter – painter для изображения (обязательный).
// - contentDescription: String? – описание для доступности.
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - contentScale: ContentScale = ContentScale.Fit – масштабирование содержимого.
// - alignment: Alignment = Alignment.Center – выравнивание изображения.

@Composable
fun ExampleImage() {
    val image: Painter = painterResource("mario.png") // Укажите путь к вашему изображению
    Image(
        painter = image,
        contentDescription = "Пример изображения"
    )
}

// Параметры:
// - imageVector: ImageVector – иконка созданная векторной графикой (обязательный),
// - contentDescription: String? – описание для доступности.
// - modifier: Modifier = Modifier – модификатор для настройки внешнего вида и поведения.
// - contentScale: ContentScale = ContentScale.Fit – масштабирование содержимого.
// - alignment: Alignment = Alignment.Center – выравнивание изображения.

@Composable
fun ExampleImage2() {
    val icon = Icons.Default.Home
    Image(
        imageVector = icon,
        contentDescription = "Пример изображения"
    )
}
