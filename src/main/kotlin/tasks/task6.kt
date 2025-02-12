package tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class State(
    val category: String,
    val count: Double,
    val live: Boolean,
    val growUp: Double,

    val currency: String?
)

@Composable
fun task6() {
    val stats: List<State> = listOf(
        State(
            category = "Total Users",
            count = 123.826,
            live = false,
            growUp = 12.8,
            currency = ""
        ),
        State(
            category = "Premium Users",
            count = 12.561,
            live = false,
            growUp = 12.8,
            currency = ""
        ),
        State(
            category = "Total Incomes",
            count = 235.452,
            live = false,
            growUp = 12.8,
            currency = ",00€"
        ),
        State(
            category = "Total Products",
            count = 1143.0,
            live = false,
            growUp = 3.2,
            currency = ""
        ),
        State(
            category = "Active Users",
            count = 14.563,
            live = true,
            growUp = 3.2,
            currency = ""
        ),
    )

    Column(
        modifier = Modifier
            .size(315.dp, 525.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(28.dp))
        stats.forEach { state: State ->
            Column(
                modifier = Modifier
                    .padding(horizontal = 28.dp)
                    .fillMaxWidth()
                    .height(92.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(32.dp)
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                ) {
                    Text(
                        text = AnnotatedString(state.category),
                        modifier = Modifier.fillMaxHeight(),
                        color = Color(3, 7, 18),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                        textAlign = TextAlign.Left
                    )
                    if (state.live) {
                        Spacer(Modifier.width(4.dp).fillMaxHeight())
                        Row(
                            modifier = Modifier
                                .size(56.dp, 18.dp)
                                .background(Color(238, 242, 255), RoundedCornerShape(50.dp))
                                .clip(shape = RoundedCornerShape(50.dp))
                                .border(1.5.dp, Color(99, 102, 241), RoundedCornerShape(50.dp)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(
                                Modifier.size(6.dp, 6.dp).clip(CircleShape).background(Color(99, 102, 241))
                            )
                            Spacer(Modifier.width(4.dp).fillMaxHeight())
                            Text(
                                text = AnnotatedString("Live"),
                                modifier = Modifier.fillMaxHeight().width(24.dp),
                                color = Color(99, 102, 241),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font("task3/medium.ttf", weight = FontWeight.W400)),
                                textAlign = TextAlign.Left
                            )
                        }
                    }

                    Spacer(Modifier.weight(1f))

                    Box(
                        modifier = Modifier.size(32.dp, 32.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource("task6/icon-DotsThree.svg"),
                            contentDescription = "icon",
                            tint = Color(3, 7, 18),
                        )
                    }
                }
                Spacer(Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(32.dp)
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp)
                ) {
                    Text(
                        text = AnnotatedString(state.count.toString() + state.currency),
                        modifier = Modifier.fillMaxHeight(),
                        color = Color(3, 7, 18),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                        textAlign = TextAlign.Left
                    )

                    Spacer(Modifier.width(4.dp).fillMaxHeight())

                    Box(
                        modifier = Modifier.size(20.dp, 20.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource("task6/icon-ChartLineUp.svg"),
                            contentDescription = "icon",
                            tint = Color(22, 163, 74),
                        )
                    }
                    Spacer(Modifier.width(4.dp).fillMaxHeight())
                    Text(
                        text = AnnotatedString(state.growUp.toString() + "%"),
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(align = Alignment.CenterVertically),
                        color = Color(22, 163, 74),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font("task3/medium.ttf", weight = FontWeight.W400)),
                        textAlign = TextAlign.Left
                    )
                }
            }
        }
    }
}