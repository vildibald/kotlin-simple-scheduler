import mu.KotlinLogging
import java.time.*
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.concurrent.timerTask

data class TaskSettings(
    val start: LocalTime,
    val every: Long,
    val interval: ChronoUnit,
    val name: String = ""
)

object Scheduler {
    private val timer = Timer(true)

    fun schedule(
        settings: TaskSettings,
        task: () -> Unit
    ) {
        timer.scheduleAtFixedRate(
            timerTask {
                task()
            },
            Date.from(
                settings.start
                    .atDate(LocalDate.now())
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
            ),
            Duration.of(settings.every, settings.interval).toMillis()
        )
    }
}
