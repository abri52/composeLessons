package tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
private fun post(
    image: String,
    title: String,
    date: String,
    link: String
) {
    Column(
        modifier = Modifier
            .width(345.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable {  }
            .padding(horizontal = 16.dp, vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().height(209.dp)
        ) {
            val image: Painter = painterResource(image)
            Image(
                painter = image,
                contentDescription = "image",
                modifier = Modifier.fillMaxSize(),
            )
        }
        Spacer(Modifier.height(30.dp).fillMaxWidth())
        Text(
            text = AnnotatedString(title),
            modifier = Modifier.height(45.dp).fillMaxWidth(),
            color = Color.Black,
            fontSize = 30.sp,
            fontFamily = FontFamily(Font("task7/base.ttf", weight = FontWeight.W400)),
            textAlign = TextAlign.Left
        )

        Text(
            text = AnnotatedString(date),
            modifier = Modifier.height(34.dp).fillMaxWidth(),
            color = Color(44, 48, 52, 48),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font("task7/base.ttf", weight = FontWeight.W400)),
            textAlign = TextAlign.Left
        )
        Spacer(Modifier.height(15.dp).fillMaxWidth())
        Text(
            text = AnnotatedString(link),
            modifier = Modifier.height(72.dp).fillMaxWidth(),
            color = Color(76, 77, 226),
            fontSize = 24.sp,
            fontFamily = FontFamily(Font("task7/base2.ttf", weight = FontWeight.W400)),
            textAlign = TextAlign.Left,
            textDecoration = TextDecoration.Underline,
            minLines = 2
        )
    }
}

@Composable
fun task7() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(44, 48, 52))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.height(701.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxHeight().width(665.dp)
            ) {
                val image: Painter = painterResource("task7/yesyes.png")
                Image(
                    painter = image,
                    contentDescription = "main image",
                    modifier = Modifier.fillMaxSize(),
                )
            }
            Column(
                modifier = Modifier.fillMaxSize().padding(top = 132.dp, start = 135.dp, end = 175.dp, bottom = 81.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = AnnotatedString("APPLY FOR ADMISSION"),
                    modifier = Modifier.height(56.dp).fillMaxWidth(),
                    color = Color.White,
                    fontSize = 39.sp,
                    fontFamily = FontFamily(Font("task7/base.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
                Spacer(
                    modifier = Modifier
                        .size(96.dp, 7.dp)
                        .background(color = Color(146, 53, 65))
                )
                Spacer(
                    modifier = Modifier
                        .height(26.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                )
                Text(
                    text = AnnotatedString("2021 Applications are now open"),
                    modifier = Modifier.height(46.dp).fillMaxWidth(),
                    color = Color(255, 255, 255, 65),
                    fontSize = 32.sp,
                    fontFamily = FontFamily(Font("task7/base.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                )
                Text(
                    text = AnnotatedString("University admission and colledge admission is now open for individuals who wants learn pursue art courses on campus."),
                    modifier = Modifier.height(132.dp).fillMaxWidth(),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font("task7/base2.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                )
                Button(
                    modifier = Modifier.size(285.dp, 78.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(203, 199, 190)),
                    shape = RectangleShape,
                ) {
                    Text(
                        text = AnnotatedString("APPLY NOW"),
                        color = Color(44, 48, 52),
                        fontSize = 36.sp,
                        fontFamily = FontFamily(Font("task7/base.ttf", weight = FontWeight.W400)),
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(181.dp).fillMaxWidth())
        Text(
            text = AnnotatedString("OUR BLOG POST"),
            modifier = Modifier.height(59.dp).fillMaxWidth(),
            color = Color.White,
            fontSize = 39.sp,
            fontFamily = FontFamily(Font("task7/base.ttf", weight = FontWeight.W400)),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(68.dp).fillMaxWidth())
        Row(
            modifier = Modifier
                .height(466.dp)
                .fillMaxWidth()
                .background(Color(44, 48, 52)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            post(
                image = "task7/img.png",
                title = "Callander and Newsletter",
                date = "June 24,2021",
                link = " Read  about our operations"
            )
            Spacer(Modifier.width(20.dp).fillMaxHeight())
            post(
                image = "task7/img2.png",
                title = "School News",
                date = "October 4,2021",
                link = "Read the latest news about our development"
            )
            Spacer(Modifier.width(20.dp).fillMaxHeight())
            post(
                image = "task7/img3.png",
                title = "Student Voice",
                date = "October 20,2021",
                link = "what the student has to say and what they think...."
            )
        }
    }
}