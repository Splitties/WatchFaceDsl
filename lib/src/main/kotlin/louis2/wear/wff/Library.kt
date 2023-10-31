/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
@file:OptIn(ExperimentalUnsignedTypes::class)

package louis2.wear.wff

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import louis2.wear.wff.clock.*
import louis2.wear.wff.common.*
import louis2.wear.wff.common.variant.ambientVariant
import louis2.wear.wff.complication.*
import louis2.wear.wff.samples.simpleDigital
import louis2.wear.wff.group.configuration.booleanConfiguration
import louis2.wear.wff.group.configuration.booleanOption
import louis2.wear.wff.group.part.draw.gradient.sweepGradient
import louis2.wear.wff.group.part.draw.partDraw
import louis2.wear.wff.group.part.draw.shape.arc
import louis2.wear.wff.group.part.draw.style.stroke
import louis2.wear.wff.group.part.image.image
import louis2.wear.wff.group.part.image.imageFilter.hsbFilter
import louis2.wear.wff.group.part.image.imageFilter.imageFilters
import louis2.wear.wff.group.part.image.partImage
import louis2.wear.wff.group.part.text.font
import louis2.wear.wff.group.part.text.formatter.template
import louis2.wear.wff.group.part.text.partText
import louis2.wear.wff.group.part.text.text
import louis2.wear.wff.userConfiguration.*
import kotlin.math.PI

internal class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }
}

context(WatchFaceDsl<T>)
internal fun <T> sampleWatchFace(
    w: Int = 480,
    h: Int = 480
): T = watchFace(width = w, height = h) {
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
    clockType(type = ClockType.DIGITAL)
    previewTime("07:35:15")
    stepGoal(9_000)
    userConfigurations {
        booleanConfiguration(
            id = "something",
            displayName = "Something",
            defaultValue = true
        )
        booleanConfiguration(
            id = "something.whatever",
            displayName = "Whatever if something",
            defaultValue = true
        )
        listConfiguration(
            id = "list.stuff",
            displayName = "Stuff",
            defaultValue = 0
        ) {
            listOption(
                id = 0,
                displayName = "First option"
            )
            listOption(
                id = 1,
                displayName = "Second option"
            )
            listOption(
                id = 2,
                displayName = "Third option"
            )
        }
        colorConfiguration(
            id = "bg",
            displayName = "Some color choices",
            defaultValue = "red&yellow"
        ) {
            colorOption(
                id = "dark_blue",
                color = Color.rgb(0x00_00_03)
            )
            colorOption(
                id = "black",
                color = Color.black
            )
        }
        colorConfiguration(
            id = "some_color_set",
            displayName = "Some color choices",
            defaultValue = "red&yellow"
        ) {
            colorOption(
                id = "red&yellow",
                colors = listOf(Color.rgb(0xFF0000), Color.rgb(0xFFFF00))
            )
            colorOption(
                id = "blue&yellow",
                colors = listOf(Color.rgb(0x0000FF), Color.rgb(0xFFFF00))
            )
        }
    }
    scene(backgroundColor = Color.configurable(id = "bg", index = 0)) {
        val supportedTypes = listOf(ComplicationType.SHORT_TEXT, ComplicationType.RANGED_VALUE, ComplicationType.MONOCHROMATIC_IMAGE)
        complicationSlot(
            slotId = 0,
            supportedTypes = supportedTypes
        ) {
            boundingOval()
            defaultProviderPolicy(defaultSystemProvider = SystemProvider.WATCH_BATTERY, ComplicationType.RANGED_VALUE)
            complication(ComplicationType.SHORT_TEXT) {
                partText {
                    text {
                        font(size = 30f) {
                            template(text = "Salut")
                        }
                    }
                }
            }
            complication(ComplicationType.RANGED_VALUE) {
                partImage {
                    image(resource = COMPLICATION.MONOCHROMATIC_IMAGE)
                    imageFilters { hsbFilter(hueRotate = 120f) }
                }
                partText { text { font(size = 30f) { template(text = COMPLICATION.TEXT) } } }
                partDraw {
                    arc(
                        centerX = centerX,
                        centerY = centerY,
                        width = this.width.toFloat(),
                        height = this.height.toFloat(),
                        startAngle = 0f,
                        endAngle = 0f
                    ) {
                        val circumference = this.width * PI
                        val dashesCount = 12
                        val dashMaxSpace = (circumference / dashesCount).toFloat()
                        stroke(
                            thickness = 8f,
                            dashIntervals = floatArrayOf(8f, dashMaxSpace - 8f)
                        ) {
                            sweepGradient(
                                centerX = this@arc.width / 2f,
                                centerY = this@arc.height / 2f,
                                startAngle = 0f,
                                endAngle = 360f,
                                colors = listOf(Color.rgb(0xFFFFFF), Color.rgb(0x00BBFF))
                            )
                        }
                    }
                }
            }
        }
        condition { default { condition { } } }
        booleanConfiguration(id = "something") {
            booleanOption(value = true) {
                group {
                    booleanConfiguration(id = "something.whatever") {
                        booleanOption(value = true) {
                            group {}
                        }
                        booleanOption(value = false) {
                            group {}
                        }
                    }
                }
            }
        }
        group(id = "g1") {
            partText {
                launch(target = LAUNCH.ALARM)
                text { font(size = 20f) { template(text = "See alarms") } }
            }
            condition {
                expressions { expression("alwaysTrue") { 0 `==` 0.l } }
                compare("alwaysTrue") {
                    group { }
                }
            }
            group(id = "g2") {}
            analogClock {
                ambientVariant(
                    target = "tintColor",
                    value = "#" + "f".repeat(8)
                )
                hourHand(resource = "hands/hour.png") {
                    ambientVariant(
                        target = "resource",
                        value = "hands/hour-ambient.png"
                    )
                }
                minuteHand(resource = "hands/minute.png") {
                    ambientVariant(
                        target = "resource",
                        value = "hands/minute-ambient.png"
                    )
                }
                secondHand(resource = "hands/second.png") {
                    ambientVariant(
                        target = "resource",
                        value = "hands/second-ambient.png"
                    )
                    sweep(frequency = 15)
                    tick(duration = .2f, strength = 1f)
                }
            }
        }
        //TODO: Add ListConfiguration
        //TODO: Add ComplicationSlot
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
        a(href = "https://jetbrains.com") {
            href = "d.android.com"
        }
    }
}

internal fun main() {
    if (false) with(WatchFaceDsl()) {
        println(sampleWatchFace())
    }
    with(WatchFaceDsl()) {
        println(simpleDigital())
    }
    if (false) with(createHTML(xhtmlCompatible = true)) {
        println(kotlinxHtmlExample())
    }
}

//@HtmlTagMarker
internal fun DIV.lol() {
    +"lol"
}

