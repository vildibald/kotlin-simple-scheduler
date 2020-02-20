# Simple scheduler for Kotlin
A single class scheduler for Kotlin 

#### Example

This will print every 5 seconds. 
Start is delayed by 2 seconds.

```kotlin
 Scheduler.schedule(
        TaskSettings(
            start = LocalTime.now().plusSeconds(2),
            name = "Writing time",
            every = 5,
            interval = ChronoUnit.SECONDS
        )
    ) { println("Time is ${LocalTime.now()}") }
```
