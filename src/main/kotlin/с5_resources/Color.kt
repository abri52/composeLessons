package с5_resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ColorExample(){
    val RedColor = Color.Red
    val BlueColor = Color.Blue
    val GreenColor = Color.Green
    val BlackColor = Color.Black
    val WhiteColor = Color.White

    val CustomColor1 = Color(0xFF123456) // Полная непрозрачность (FF) и RGB = 12, 34, 56
    val SemiTransparentColor = Color(0x80123456) // Прозрачность 50% (80) и RGB = 12, 34, 56
}