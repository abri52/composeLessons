package tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun task5() {
    var liked by remember { mutableStateOf<Boolean>(false) }

    Column(
        modifier = Modifier.size(274.dp, 424.dp).padding(top = 21.dp, start = 17.dp, end = 17.dp, bottom = 22.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            val image: Painter = painterResource("task5/Prato.png")
            Image(
                painter = image,
                contentDescription = "main image",
                modifier = Modifier.size(240.dp, 180.dp),
            )
        }
        Text(
            text = AnnotatedString("Carne Louca"),
            modifier = Modifier.size(150.dp, 22.dp),
            color = Color(156, 75, 0),
            fontFamily = FontFamily(Font("task5/Poppins-SemiBold.ttf", weight = FontWeight.W500)),
            fontSize = 16.sp,
        )
        Text(
            text = AnnotatedString("ITALIANO"),
            modifier = Modifier.size(98.dp, 22.dp),
            color = Color(153, 153, 153),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font("task5/Poppins-Regular.ttf", weight = FontWeight.W400)),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = AnnotatedString("Fabiana"),
                modifier = Modifier.size(75.dp, 22.dp),
                color = Color(0, 0, 0),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font("task5/Poppins-Medium.ttf", weight = FontWeight.W400)),
            )
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource("task5/icon1.svg"),
                contentDescription = "relogio",
                modifier = Modifier.size(12.dp, 12.dp),
            )

            Spacer(modifier = Modifier.weight(0.05f))
            Text(
                text = AnnotatedString("0h50min"),
                modifier = Modifier.size(86.dp, 22.dp),
                color = Color(0, 0, 0),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font("task5/Poppins-Regular.ttf", weight = FontWeight.W400)),
            )
        }
        Spacer(modifier = Modifier.weight(9f))
        Text(
            text = AnnotatedString("“Sua origem é italiana, parente da carne lessa, receita à base...”"),
            modifier = Modifier.size(240.dp, 61.dp),
            color = Color(165, 165, 165),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font("task5/Poppins-Light.ttf", weight = FontWeight.W400)),
        )
        Row(
            modifier = Modifier.size(239.9.dp, 27.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource("task5/heart.svg"),
                contentDescription = "relogio",
                modifier = Modifier.size(23.dp, 22.dp).clickable(onClick = {liked = !liked}),
                tint = if (liked) Color(255, 122, 0) else Color(104, 104, 104)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.size(65.9.dp, 27.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val images = arrayOf("1.png", "2.png", "3.png")
                images.forEach {
                    Image(
                        painter = painterResource("task5/$it"),
                        contentDescription = "eeee",
                        modifier = Modifier.size(23.26.dp, 23.dp).offset(x = -(8.dp * images.indexOf(it))),
                    )
                }
                Box(
                    modifier = Modifier
                        .size(23.26.dp, 23.dp)
                        .background(Color(253, 253, 253), CircleShape)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = AnnotatedString("+${if (liked) 51 else 50}"),
                        modifier = Modifier.size(240.dp, 61.dp),
                        color = Color(165, 165, 165),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font("task5/Poppins-Light.ttf", weight = FontWeight.W400)),
                    )
                }
            }
        }
    }
}