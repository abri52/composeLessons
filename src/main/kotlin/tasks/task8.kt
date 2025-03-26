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
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun task8() {
    var variant by remember { mutableStateOf<String?>(null) }
    val variants = arrayOf("Small", "Medium", "Big")
    var quantity by remember { mutableStateOf<Int>(1) }

    Row(
        modifier = Modifier.size(1174.dp, 846.dp).background(Color.White).padding(vertical = 200.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.width(586.dp).fillMaxHeight().background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f).size(30.dp, 124.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource("task8/Arrow Left.svg"),
                    contentDescription = "icon",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color(131, 132, 137)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight().width(562.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val image: Painter = painterResource("task8/Image.png")
                    Image(
                        painter = image,
                        contentDescription = "image",
                        modifier = Modifier.size(562.dp, 342.dp),
                    )
                }

                Row(
                    modifier = Modifier.size(124.dp, 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(5) { i ->
                        Box(
                            modifier = Modifier
                                .size(14.dp, 14.dp)
                                .background(if (i == 0) Color(45, 46, 50) else Color(185, 186, 191), CircleShape)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier.weight(1f).size(30.dp, 124.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource("task8/Arrow Right.svg"),
                    contentDescription = "icon",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color(131, 132, 137)
                )
            }
        }

        // Pricing Section
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxHeight().width(442.dp)
        ) {
            Text(
                text = AnnotatedString("€1588.00*"),
                modifier = Modifier.height(34.dp).fillMaxWidth(),
                color = Color(45, 46, 50),
                fontSize = 24.sp,
                fontFamily = FontFamily(Font("task8/Inter_Bold.ttf", weight = FontWeight.Bold)),
                textAlign = TextAlign.Left,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = AnnotatedString("Content: 100 Stück (€0.88* / 1 Stück)"),
                modifier = Modifier.height(16.dp).fillMaxWidth(),
                color = Color(45, 46, 50),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font("task8/Inter.ttf", weight = FontWeight.Normal)),
                textAlign = TextAlign.Left,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = AnnotatedString("Prices incl. VAT plus shipping costs"),
                modifier = Modifier.height(16.dp).fillMaxWidth(),
                color = Color(11, 83, 155),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font("task8/Inter.ttf", weight = FontWeight.Normal)),
                textAlign = TextAlign.Left,
            )
            Spacer(Modifier.height(22.dp))
            Row(
                modifier = Modifier
                    .height(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier.size(10.dp, 10.dp).clip(CircleShape).background(Color(38, 182, 207))
                )
                Spacer(Modifier.width(5.dp).fillMaxHeight())
                Text(
                    text = AnnotatedString("Free Shipping"),
                    modifier = Modifier.fillMaxHeight(),
                    color = Color(45, 46, 50),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task8/Inter.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
            }
            Spacer(Modifier.height(22.dp))
            Row(
                modifier = Modifier
                    .height(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier.size(10.dp, 10.dp).clip(CircleShape).background(Color(0, 120, 24))
                )
                Spacer(Modifier.width(5.dp).fillMaxHeight())
                Text(
                    text = AnnotatedString("Available, delivery time 1-3 days"),
                    modifier = Modifier.fillMaxHeight(),
                    color = Color(45, 46, 50),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task8/Inter.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
            }
            Spacer(Modifier.height(22.dp))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = AnnotatedString("Variant title"),
                    modifier = Modifier.height(12.dp),
                    color = Color(45, 46, 50),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task8/Inter_SemiBold.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
                Spacer(Modifier.height(16.dp))
                Row(
                    modifier = Modifier.height(32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    variants.forEach { yes ->
                        Button(
                            modifier = Modifier.height(34.dp),
                            onClick = { variant = yes },
                            colors =
                                if (yes == variant) {
                                    ButtonDefaults.buttonColors(backgroundColor = Color(11, 83, 155))
                                } else {
                                    ButtonDefaults.buttonColors(backgroundColor = Color.White)
                                },
                            shape = RectangleShape,
                            border = _root_ide_package_.androidx.compose.foundation.BorderStroke(1.dp, if (variant != yes) Color.Gray else Color.Transparent)
                        ) {
                            Text(
                                text = AnnotatedString(yes),
                                color = if (yes == variant) Color.White else Color(44, 48, 52),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font("task8/Inter.ttf", weight = FontWeight.W400)),
                            )
                        }
                        Spacer(Modifier.width(7.dp))
                    }
                }

                Spacer(Modifier.height(22.dp))
                Text(
                    text = AnnotatedString("Quantity"),
                    color = Color(45, 46, 50),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task8/Inter_SemiBold.ttf", weight = FontWeight.W400)),
                    textAlign = TextAlign.Left
                )
                Spacer(Modifier.height(16.dp))
                Row(
                    modifier = Modifier.size(142.dp, 36.dp).border(1.47.dp, Color(131, 132, 137)).padding(horizontal = 13.2.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.size(15.dp, 15.dp).clickable(onClick = {if (quantity > 1) quantity -= 1}),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource("task8/Minus.svg"),
                            contentDescription = "icon",
                            tint = Color(45, 46, 50),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(
                        text = AnnotatedString(quantity.toString()),
                        color = Color(74, 84, 91),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font("task8/Inter_SemiBold.ttf", weight = FontWeight.W400)),
                    )
                    Box(
                        modifier = Modifier.size(15.dp, 15.dp).clickable(onClick = {if (quantity < 10) quantity += 1}),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource("task8/Plus.svg"),
                            contentDescription = "icon",
                            tint = Color(45, 46, 50),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Spacer(Modifier.height(22.dp))
                Button(
                    modifier = Modifier.size(380.dp, 40.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(11, 83, 155)),
                    shape = RectangleShape,
                ) {
                    Text(
                        text = AnnotatedString("Add to shopping cart"),
                        modifier = Modifier,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font("task8/Inter_SemiBold.ttf", weight = FontWeight.W400)),
                    )
                }

                val annotatedText = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = FontFamily(Font("task8/Inter_SemiBold.ttf", weight = FontWeight.W400)))) {
                        append("Product number: ")
                    }
                    withStyle(style = SpanStyle(fontFamily = FontFamily(Font("task8/Inter.ttf", weight = FontWeight.W400)))) {
                        append("drill-189")
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = annotatedText,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(45, 46, 50),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font("task8/Inter_SemiBold.ttf", weight = FontWeight.W400)),
                )
            }
        }
    }

    LaunchedEffect(null) {
        variant = variants.first()
    }
}
