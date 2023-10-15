/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package louis2.wear.wff

import kotlinx.html.*
import kotlinx.html.stream.createHTML

internal class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }
}

context(TagConsumer<T>)
internal fun <T> sampleWatchFace(
    width: Int = 480,
    height: Int = 480
): T = watchFace(width = width, height = height) {
    scene(backgroundColor = 0xFF_000003u) {
        clockType(type = ClockType.DIGITAL)
        previewTime("07:35:15")
        stepGoal(9_000)
        bitmapFonts {
            bitmapFont(name = "whatever") {
                for (c in 0..9) character(
                    name = "$c",
                    resource = "whatever/$c.png",
                    width = 20,
                    height = 30
                )
                word(
                    name = "11",
                    resource = "whatever/11-fancy.png",
                    width = 20 * 2,
                    height = 30
                )
            }
        }
    }
}

context(TagConsumer<T>)
internal fun <T> kotlinxHtmlExample(): T = html {
    body {
        div outerDiv@{
            lol()
            button {
                this@outerDiv.lol()
//                    lol()
            }
        }
        h1 { +"Lol" }
        a(href = "https://jetbrains.com")
    }
}

internal fun main() {
    with(createHTML(xhtmlCompatible = true)) {
        println(sampleWatchFace())
        println(kotlinxHtmlExample())
    }
}

//@HtmlTagMarker
internal fun DIV.lol() {

}

