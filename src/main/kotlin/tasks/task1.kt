package tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.ResourceFont
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val size: DpSize = DpSize(375.dp, 80.dp)


@Composable
fun task1() {
    val icons: List<String> = listOf(
        "task1/Home.svg",
        "task1/Find.svg",
        "task1/Plus.svg",
        "task1/Chat.svg",
        "task1/Users.svg"
    )

    Row(
        modifier = Modifier.size(375.dp, 80.dp).background(Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icons.forEach {
            if (it != "task1/Plus.svg") {
                Box(
                    modifier = Modifier.weight(1f).size(48.dp, 48.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(it),
                        contentDescription = "icon",
                        tint = Color.White,
                    )
                }
            }
            else {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .size(48.dp, 48.dp)
                        .clip(androidx.compose.foundation.shape.CircleShape)
                        .background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(it),
                        contentDescription = "icon",
                        tint = Color.Black,
                    )
                }
            }
            if (it != "task1/Users.svg") {
                Spacer(modifier = Modifier.weight(.5f))
            }
        }
    }
}
