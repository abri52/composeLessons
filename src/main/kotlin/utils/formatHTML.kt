package utils.formatHtml

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import org.jsoup.Jsoup

fun parseHtml(html: String): AnnotatedString {
    val document = Jsoup.parse(html)
    val text = document.body().text()

    return buildAnnotatedString {
        append(text)
    }
}
