package tasks

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil3.compose.rememberAsyncImagePainter
import io.github.vinceglb.confettikit.compose.ConfettiKit
import io.github.vinceglb.confettikit.core.Angle
import io.github.vinceglb.confettikit.core.Party
import io.github.vinceglb.confettikit.core.Position
import io.github.vinceglb.confettikit.core.Spread
import io.github.vinceglb.confettikit.core.emitter.Emitter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Part
import kotlin.time.Duration.Companion.seconds

object RetrofitClient {
    private const val BASE_URL = "https://api.thecatapi.com/"

    val instance: CatApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }
}

data class CatImage(val url: String)

interface CatApi {
    @GET("v1/images/search")
    fun getRandomCatImage(): Call<List<CatImage>>
}

fun getRandomCatImage(onResult: (String?) -> Unit) {
    val catApi = RetrofitClient.instance
    catApi.getRandomCatImage().enqueue(object : Callback<List<CatImage>> {
        override fun onResponse(call: Call<List<CatImage>>, response: Response<List<CatImage>>) {
            if (response.isSuccessful) {
                val catImageUrl = response.body()?.firstOrNull()?.url
                onResult(catImageUrl)
            } else {
                onResult(null)
            }
        }

        override fun onFailure(call: Call<List<CatImage>>, t: Throwable) {
            t.printStackTrace()
            onResult(null)
        }
    })
}



@Composable
fun task8() {
    var catImageUrl by remember { mutableStateOf<String?>(null) }
    var catImageUrl2 by remember { mutableStateOf<String?>(null) }

    val rounds = 8
    var currentRound by remember {
        mutableStateOf(0)
    }

    var finalImage by remember { mutableStateOf<String?>(null) }


    var isLoading: Boolean = false

    fun round(image: Int?) {
        println("round")
        if (currentRound >= rounds) {
            return
        }
        currentRound++
        isLoading = true
        println(currentRound)

        if (image == null) {
            getRandomCatImage { url ->
                catImageUrl = url
            }
            getRandomCatImage { url ->
                catImageUrl2 = url
                isLoading = false
            }
        }
        else {
            getRandomCatImage { url ->
                if (image == 1) catImageUrl = url
                else catImageUrl2 = url

                if (currentRound == rounds) {
                    finalImage = url
                }

                isLoading = false
            }
        }

    }

    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (currentRound < rounds) {
            BoxWithConstraints {
                val maxWidth = this.maxWidth
                Image(
                    painter = rememberAsyncImagePainter(catImageUrl),
                    contentDescription = "random",
                    modifier = Modifier
                        .fillMaxHeight().width(maxWidth / 3)
                        .clickable(enabled = !isLoading, onClick = { round(2) })
                )
            }
            Spacer(Modifier.width(10.dp).fillMaxHeight())
            BoxWithConstraints {
                val maxWidth = this.maxWidth
                Image(
                    painter = rememberAsyncImagePainter(catImageUrl2),
                    contentDescription = "random",
                    modifier = Modifier
                        .fillMaxHeight().width(maxWidth / 3)
                        .clickable(enabled = !isLoading, onClick = { round(1) })
                )
            }
        }
        else {
            BoxWithConstraints {
                val maxWidth = this.maxWidth
                Image(
                    painter = rememberAsyncImagePainter(finalImage),
                    contentDescription = "random",
                    modifier = Modifier
                        .size(maxWidth / 3)
                        .animateContentSize()
                )
            }

            // complete
        }
    }

    finalImage.let {
        println(finalImage)
        ConfettiKit(
            modifier = Modifier.fillMaxSize(),
            parties = listOf(Party(
                speed = 0f,
                maxSpeed = 15f,
                damping = 0.9f,
                angle = Angle.BOTTOM,
                spread = Spread.ROUND,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
                emitter = Emitter(duration = 3.5.seconds).perSecond(100),
                position = Position.Relative(0.0, 0.0).between(Position.Relative(1.0, 0.0))
            ))
        )
    }

    Text(
        text = AnnotatedString("Round $currentRound/$rounds"),
        modifier = Modifier.fillMaxWidth().height(22.dp),
        color = Color(3, 7, 18),
        fontSize = 14.sp,
        fontFamily = FontFamily(Font("task3/extraBold.ttf", weight = FontWeight.W600)),
        textAlign = TextAlign.Center
    )

    LaunchedEffect(null) {
        round(null)
    }
}