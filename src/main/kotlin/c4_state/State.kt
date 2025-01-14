package c4_state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*

    State (состояние) представляет собой данные,
    которые могут изменяться со временем и влиять на
    внешний вид или поведение пользовательского интерфейса (UI).

 */

@Composable
fun CounterExample() {
    // Создаём состояние счётчика, которое сохраняется между рекомпозициями
    var count by remember { mutableStateOf(0) }

    // Центрируем содержимое на экране
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Счётчик: $count", modifier = Modifier.padding(16.dp))
        Button(onClick = { count++ }) {
            Text("Увеличить")
        }
    }
}