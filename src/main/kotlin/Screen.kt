import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Screen() {
    Column {
        Row {
            Text("gdfgdfgfdg", color = Color(144,144,144))
            Text(text = "hi")
        }
        Button(onClick = {}) {
            Text("Нажми меня")
        }
    }
}