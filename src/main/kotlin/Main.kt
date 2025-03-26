import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication, state = WindowState(placement = WindowPlacement.Maximized)) { // 274, 424
        tasks.task5()
    }
}
