import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import tasks.task5

fun main() = application {
    Window(onCloseRequest = ::exitApplication, state = WindowState(size = DpSize(1450.dp, 1597.dp))) { // 274, 424
        tasks.task7()
    }
}
