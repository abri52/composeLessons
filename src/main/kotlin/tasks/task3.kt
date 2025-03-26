package tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.border
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import kotlinx.coroutines.delay
import utils.getFormatedNumber

@Composable
fun task3() {
    class State(
        val category: String,
        var count: Int
    )

    var stats by remember { mutableStateOf<List<State>>(listOf(
        State(
            category = "Posts",
            count = 548
        ),
        State(
            category = "Followers",
            count = 12700
        ),
        State(
            category = "Following",
            count = 221
        ),
    )) }

    Column(
        modifier = Modifier
            .size(370.dp, 350.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .size(320.dp, 274.dp)
                .background(Color.White)
                .padding(horizontal = 25.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource("task3/pfp.png"),
                contentDescription = "",
                modifier = Modifier.clip(CircleShape).size(96.dp, 96.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = AnnotatedString("X_AE_C-921"),
                modifier = Modifier.height(28.dp).fillMaxWidth(),
                color = Color(30, 41, 59),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W800)),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = AnnotatedString("@xtheobliterator"),
                modifier = Modifier.height(22.dp).fillMaxWidth(),
                color = Color(30, 41, 59),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font("task3/medium.ttf", weight = FontWeight.W500)),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = AnnotatedString("Osaka, Japan \uD83C\uDF8C "),
                modifier = Modifier.height(22.dp).fillMaxWidth(),
                color = Color(71, 85, 105),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font("task3/medium.ttf", weight = FontWeight.W500)),
                textAlign = TextAlign.Center
            )
        }
//        Spacer(Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(50.dp).fillMaxWidth()
        ) {
            stats.forEach { yesyes: State ->
                Column(
                    modifier = Modifier.weight(1f).height(50.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = AnnotatedString(getFormatedNumber(yesyes.count.toLong())),
                        modifier = Modifier.height(28.dp).fillMaxWidth(),
                        color = Color(30, 41, 59),
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W800)),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = AnnotatedString(yesyes.category),
                        modifier = Modifier.height(22.dp).fillMaxWidth(),
                        color = Color(71, 85, 105),
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font("task3/semiBold.ttf", weight = FontWeight.W600)),
                        textAlign = TextAlign.Center
                    )
                }
                if (stats.indexOf(yesyes) != stats.lastIndex) {
                    Spacer(modifier = Modifier
                        .width(2.dp)
                        .fillMaxHeight()
                        .background(color = Color(203, 213, 225))
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit){
        while(true){
            delay(2000)
            stats[(0..(stats.size - 1)).random()].count += (0..5).random()
        }
    }
}