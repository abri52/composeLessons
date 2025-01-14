package c2_layout

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Компонент: Spacer
// Параметры:
// - modifier: Modifier – модификатор для задания размера и отступов (обязательный).

@Composable
fun ExampleSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}
