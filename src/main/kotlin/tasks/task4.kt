package tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import java.lang.module.ModuleFinder


@Composable
fun task4() {
    var comments by remember { mutableStateOf<Int>(16) }
    var pins by remember { mutableStateOf<Int>(4) }

    Column(
        modifier = Modifier
            .size(352.dp, 405.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(48.dp).fillMaxWidth().padding(horizontal = 32.dp)
        ) {
            Box(
                Modifier
                    .size(56.dp, 8.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(3, 218, 197)
                )
            )
            Spacer(Modifier.width(10.dp))
            Box(
                Modifier
                    .size(56.dp, 8.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(236, 64, 122)
                )
            )
            Spacer(Modifier.width(10.dp))
            Box(
                Modifier
                    .size(56.dp, 8.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(255, 193, 7)
                )
            )

            Spacer(Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.size(21.dp, 5.dp)
            ) {
                repeat(3) {
                    Box(
                        Modifier
                            .size(5.dp, 5.dp)
                            .clip(CircleShape)
                            .background(Color(207, 216, 220)
                        )
                    )
                    Spacer(Modifier.weight(1f))
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().height(197.dp)
        ) {
            val image: Painter = painterResource("task4/main_image.png")
            Image(
                painter = image,
                contentDescription = "main image",
                modifier = Modifier.size(288.dp, 197.dp).clip(RoundedCornerShape(16)),
            )
        }
        Spacer(Modifier.height(15.dp))
        Text(
            text = AnnotatedString("Enter Text"),
            modifier = Modifier.height(36.dp).fillMaxWidth(),
            color = Color(30, 41, 59),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font("task4/extraBold.ttf", weight = FontWeight.W800)),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth().height(34.dp).padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val image: Painter = painterResource("task4/img.png")
            Image(
                painter = image,
                contentDescription = "image52",
                modifier = Modifier.fillMaxHeight().width(170.dp),
            )

            Spacer(Modifier.weight(1f))

            Row(
                modifier = Modifier.size(33.dp, 13.dp).clickable(onClick = {comments++}),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource("task4/message.svg"),
                    contentDescription = "icon",
                    tint = Color(207, 216, 220),
                    modifier = Modifier.size(13.dp, 13.dp)
                )
                Text(
                    text = AnnotatedString(comments.toString()),
                    modifier = Modifier.fillMaxHeight().width(20.dp),
                    color = Color(144, 164, 174),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task4/medium.ttf", weight = FontWeight.W500)),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.width(17.dp))

            Row(
                modifier = Modifier.size(26.dp, 13.dp).clickable(onClick = {pins++}),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource("task4/pin.svg"),
                    contentDescription = "icon",
                    tint = Color(207, 216, 220),
                    modifier = Modifier.size(13.dp, 13.dp)
                )
                Text(
                    text = AnnotatedString(pins.toString()),
                    modifier = Modifier.fillMaxHeight().width(13.dp),
                    color = Color(144, 164, 174),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task4/medium.ttf", weight = FontWeight.W500)),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}