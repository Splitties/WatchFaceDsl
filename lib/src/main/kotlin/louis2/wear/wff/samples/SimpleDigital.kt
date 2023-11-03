package louis2.wear.wff.samples

import louis2.wear.wff.*
import louis2.wear.wff.clock.TIMETEXT.HourFormat.SYNC_TO_DEVICE
import louis2.wear.wff.clock.digitalClock
import louis2.wear.wff.clock.timeText
import louis2.wear.wff.common.variant.ambientVariant
import louis2.wear.wff.group.part.text.FONT.Weight.THIN
import louis2.wear.wff.group.part.text.font
import louis2.wear.wff.group.part.text.formatter.template
import louis2.wear.wff.group.part.text.partText
import louis2.wear.wff.group.part.text.text

/**
 * Taken from https://github.com/android/wear-os-samples/blob/main/WatchFaceFormat/SimpleDigital/res/raw/watchface.xml
 */
context(WatchFaceDsl<T>)
internal fun <T> simpleDigital(): T = watchFace(width = 450, height = 450) {
    clockType(ClockType.DIGITAL)
    metadata("TICK_PER_SECOND", "15")
    previewTime("10:08:32")
    scene {
        digitalClock {
            comment(" SYNC_TO_DEVICE specifies to respect the device 12/24h setting ")
            comment(" Interactive mode version")
            timeText(
                format = "hh:mm",
                hourFormat = SYNC_TO_DEVICE,
                align = Alignment.CENTER,
                y = 175,
                height = 100
            ) {
                ambientVariant(attrs.alpha, 0)
                font(
                    size = 128f,
                    color = Color.white
                )
            }
            comment(" Ambient mode version - thinner weight ")
            timeText(
                format = "hh:mm",
                align = Alignment.CENTER,
                y = 175,
                height = 100,
                alpha = 0u
            ) {
                ambientVariant(attrs.alpha, 0xFF)
                font(
                    size = 128f,
                    weight = THIN,
                    color = Color.white
                )
            }
        }
        group(name = "hello_world") {
            partText(y = 285, height = 50) {
                ambientVariant(attrs.alpha, 0)
                text {
                    font(
                        size = 36f,
                        color = Color.white
                    ) {
                        template(stringResourceName = "greeting")
                    }
                }
            }
        }
    }
}
