package tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.ResourceFont
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*

fun Modifier.bottomBorder(strokeWidth: Dp, color: Color) = composed (
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height - strokeWidthPx/2

            drawLine(
                color = color,
                end = Offset(x = 0f, y = height),
                start = Offset(x = width , y = height),
                strokeWidth = strokeWidthPx
            )
        }
    }
)

@Composable
fun task2() {
    var signedIn by remember { mutableStateOf<Boolean>(true) }

    Column(
        modifier = Modifier
            .size(305.dp, 88.dp)
            .background(Color.White)
            .padding(horizontal = 12.5.dp, vertical = 10.5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(.1f))
        Box(Modifier.bottomBorder(2.dp, Color(226, 232, 240)).size(305.dp, 2.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.5.dp, vertical = 10.5.dp)
        ) {
            if (signedIn) {
                Image(
                    painter = painterResource("task2/pfp.png"),
                    contentDescription = "",
                    modifier = Modifier.clip(CircleShape).size(40.dp, 40.dp),
                )
            }
            Column(
                modifier = Modifier.size(172.dp, 46.dp).padding(start = 12.dp)
            ) {
                Text(
                    text = AnnotatedString(if (signedIn) "Azunyan U. Wu" else "Guest"),
                    modifier = Modifier.size(172.dp, 22.dp),
                    color = Color(30, 41, 59),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font("task2/font.ttf", weight = FontWeight.W700)),
                )
                Text(
                    text = AnnotatedString(if (signedIn) "Basic Member" else "unknown"),
                    modifier = Modifier.size(172.dp, 22.dp),
                    color = Color(71, 85, 105),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font("task2/font2.ttf", weight = FontWeight.W500)),
                )
            }
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier.weight(1f).size(40.dp, 40.dp).clickable(onClick = {signedIn = false}),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource("task2/logout.svg"),
                    contentDescription = "icon",
                    tint = Color(71, 85, 105),
                )
            }
        }
    }
}