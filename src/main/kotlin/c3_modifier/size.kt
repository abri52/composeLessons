package c3_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SizeModifier(){
    Row(
        modifier = Modifier.fillMaxSize(), // Заполнение всей доступной ширины и высоты
        verticalAlignment = Alignment.Bottom
    ) {
        DefaultSizeExample()
        DefaultWidthAndHeightExample()
        FillMaxWidthExample()
        FillMaxHeightExample()
        SizeInExample()
        AspectRatioExample()
        RequiredSizeExample()
    }
}

@Composable
fun DefaultSizeExample(){
    Spacer(
        modifier = Modifier
            .background(Color.Red)
            .size(100.dp)
    )
}

@Composable
fun DefaultWidthAndHeightExample(){
    Spacer(
        modifier = Modifier
            .background(Color.Blue)
            .width(100.dp)
            .height(200.dp)
    )
}

@Composable
fun FillMaxWidthExample(){
    Spacer(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(0.5f) // Заполнение 50% доступной ширины
            .height(50.dp) // Фиксированная высота
    )
}

@Composable
fun FillMaxHeightExample(){
    Spacer(
        modifier = Modifier
            .background(Color.Magenta)
            .width(50.dp) // Фиксированная ширина
            .fillMaxHeight(0.8f) // Заполнение 80% доступной высоты
    )
}

@Composable
fun SizeInExample(){
    Spacer(
        modifier = Modifier
            .background(Color.Yellow)
            .sizeIn(minWidth = 60.dp, minHeight = 60.dp, maxWidth = 120.dp, maxHeight = 120.dp) // Установка минимальных и максимальных размеров
    )
}

@Composable
fun AspectRatioExample(){
    Spacer(
        modifier = Modifier
            .background(Color.Gray)
            .aspectRatio(16f / 9f) // Установка соотношения сторон 16:9
            .fillMaxWidth(0.7f) // Заполнение 70% доступной ширины
    )
}

@Composable
fun RequiredSizeExample(){
    Spacer(
        modifier = Modifier
            .background(Color.LightGray)
            .requiredSize(80.dp) // Принудительная установка размера 80x80 dp
    )
}


