package tasks

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.vinceglb.confettikit.compose.ConfettiKit
import io.github.vinceglb.confettikit.core.Angle
import io.github.vinceglb.confettikit.core.Party
import io.github.vinceglb.confettikit.core.Position
import io.github.vinceglb.confettikit.core.Rotation
import io.github.vinceglb.confettikit.core.Spread
import io.github.vinceglb.confettikit.core.emitter.Emitter
import io.github.vinceglb.confettikit.core.models.Shape
import io.github.vinceglb.confettikit.core.models.Size
import kotlinx.coroutines.delay

import utils.formatHtml.parseHtml

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.time.Duration.Companion.seconds

object client {
    private const val BASE_URL = "https://opentdb.com/"

    val instance: questionsApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(questionsApi::class.java)
    }
}

enum class Difficulty {
    easy, medium, hard
}

class question(
    val type: String,
    val category: String,
    val difficulty: Difficulty,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: List<String>
)

data class questions(val results: List<question>)

interface questionsApi {
    @GET("api.php?amount=10")
    fun getRandomQuestions(): Call<questions>
}

fun getRandomQuestions(onResult: (List<question>?) -> Unit) {
    val factApi = client.instance

    factApi.getRandomQuestions().enqueue(object : Callback<questions> {
        override fun onResponse(call: Call<questions>, response: Response<questions>) {
            if (response.isSuccessful) {
                val results = response.body()?.results
                onResult(results)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<questions>, t: Throwable) {
            t.printStackTrace()
            onResult(null)
        }
    })
}

data class Digit(val digitChar: Char, val fullNumber: Int, val place: Int) {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Digit -> digitChar == other.digitChar
            else -> super.equals(other)
        }
    }
}

operator fun Digit.compareTo(other: Digit): Int {
    return fullNumber.compareTo(other.fullNumber)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun uniqueTask2() {
    var currentRound by remember {
        mutableStateOf(0)
    }
    val rounds = 10

    var score by remember {
        mutableStateOf(0)
    }
    var debris_score by remember {
        mutableStateOf(0)
    }

    var time by remember { mutableStateOf(60) }
    var currentQuestions: List<question>? by remember { mutableStateOf<List<question>?>(null) }

    fun round() {
        println("round")
        if (currentRound >= rounds) {
            return
        }
        time = 60
        currentRound++

//        getRandomQuestions { yes ->
//            currentQuestions = yes
//        }
    }

    if (currentRound >= rounds) {
        println("ahh ur time is gone or u completed all sigma steps")
        ConfettiKit(
            modifier = Modifier.fillMaxSize(),
            parties = listOf(
                Party(
                    speed = 0f,
                    maxSpeed = 30f,
                    damping = 0.9f,
                    spread = 360,
                    colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                    emitter = Emitter(duration = 3.5.seconds).perSecond(100),
                    position = Position.Relative(0.5, 0.5)
                )
            )
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            BoxWithConstraints {
                val maxHeight = this.maxHeight

                Box(
                    modifier = Modifier.size(maxHeight / 2),
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource("uhtask/score_bg.png"),
                        contentDescription = "image",
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "Your score",
                        modifier = Modifier.fillMaxWidth().offset(y = maxHeight / 6),
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 36.sp
                    )

                    Row(
                        modifier = Modifier
                            .animateContentSize()
                            .fillMaxWidth()
                            .offset(y = maxHeight / 18)
                            .height(maxHeight / 2),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        debris_score.toString()
                            .mapIndexed { index, c -> Digit(c, score, index) }
                            .forEach { digit ->
                                AnimatedContent(
                                    targetState = digit,
                                    transitionSpec = {
                                        if (targetState > initialState) {
                                            slideInVertically { -it } togetherWith slideOutVertically { it }
                                        } else {
                                            slideInVertically { it } togetherWith slideOutVertically { -it }
                                        }
                                    }
                                ) { digit ->
                                    Text(
                                        text = "${digit.digitChar}",
                                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                                        color = Color.White,
                                        textAlign = TextAlign.Center,
                                        fontSize = 167.sp
                                    )
                                }
                            }
                    }
                }
            }
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            BoxWithConstraints {
                val maxHeight = this.maxHeight
                val maxWidth = this.maxWidth

                Row(
                    modifier = Modifier.size(maxWidth - (maxWidth / 10), maxHeight / 7)
                        .bottomBorder(0.58.dp, Color(236, 236, 232))
                ) {
                    Text(
                        text = score.toString(),
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 46.sp
                    )
                }
            }

            BoxWithConstraints {
                Spacer(Modifier.height(this.maxHeight / 7))
            }

            val currentQuestion: question? = currentQuestions?.get(currentRound)
            var answers = currentQuestion?.incorrect_answers?.toMutableList()
            answers?.add(currentQuestion?.correct_answer.toString())
            answers?.shuffle()

            val correct_answer: String = currentQuestion?.correct_answer.toString()

            println(correct_answer)

            BoxWithConstraints {
                val maxHeight = this.maxHeight

                Column(
                    modifier = Modifier.fillMaxWidth().height((maxHeight / 7) * 2).background(Color(252, 200, 34)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = parseHtml(currentQuestion?.question.toString()),
                        modifier = Modifier,
                        color = Color(255, 255, 255),
                        fontSize = 36.sp,
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                        textAlign = TextAlign.Center,
                    )
                }
            }

            BoxWithConstraints {
                Spacer(Modifier.height(this.maxHeight / 7))
            }

            BoxWithConstraints {
                val maxHeight = this.maxHeight
                val maxWidth = this.maxWidth

                Row(
                    modifier = Modifier.size(maxWidth - (maxWidth / 10), (maxHeight / 7) * 2),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    answers?.forEach { yes ->
                        Column(
                            modifier = Modifier
                                .background(color = Color(0xFFD1D1D1))
                                .fillMaxHeight()
                                .weight(1f)
                                .clickable(onClick = {
                                        when (currentQuestion?.difficulty) {
                                            Difficulty.easy -> {
                                                if (yes == correct_answer) {score -= 5}
                                                else {score += 1}
                                            }

                                            Difficulty.medium -> {
                                                if (yes == correct_answer) {score -= 3}
                                                else {score += 3}
                                            }

                                            Difficulty.hard -> {
                                                if (yes == correct_answer) {score -= 1}
                                                else {score += 5}
                                            }

                                            null -> {}
                                        }
                                        round()
                                }),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = (answers.indexOf(yes) + 1).toString(),
                                modifier = Modifier.fillMaxWidth().height(((maxHeight / 7) * 2) / 5),
                                fontFamily = FontFamily(Font("task3/semiBold.ttf", weight = FontWeight.W600)),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp
                            )
                            Text(
                                text = parseHtml(yes.toString()),
                                modifier = Modifier.fillMaxWidth(),
                                fontFamily = FontFamily(Font("task3/semiBold.ttf", weight = FontWeight.W600)),
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = 36.sp
                            )
                        }
                        if (answers.indexOf(yes) != answers.lastIndex) {
                            Spacer(Modifier.weight(.2f))
                        }
                    }
                }
            }
            Spacer(Modifier.weight(1f))
            BoxWithConstraints {
                val maxHeight = this.maxHeight
                val maxWidth = this.maxWidth

                Row(
                    modifier = Modifier.size(maxWidth - (maxWidth / 10), maxHeight / 7)
                        .bottomBorder(0.58.dp, Color(236, 236, 232))
                ) {
                    Text(
                        text = time.toString(),
                        modifier = Modifier.fillMaxWidth(),
                        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 36.sp
                    )
                }
            }
        }
    }

    LaunchedEffect(null) {
        round()

        getRandomQuestions { yes ->
            currentQuestions = yes
        }

        while (true) {
            delay(1000)

            if (time > 0 && currentRound < rounds) {
                time -= 1
            } else {
                thread {
                    Thread.sleep(100)
                    repeat(score) {
                        Thread.sleep(100)
                        debris_score += 1
                    }
                }
                currentRound = rounds
                break
            }
        }
    }
}