package opgave2StopWatch;

import java.time.Duration;
import java.time.LocalTime;

public class StopWatch {
    LocalTime startTime;
    LocalTime endTime;

    public StopWatch() {

    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        endTime = LocalTime.now();
    }

    public long elapsedTime() {
        Duration seconds = Duration.between(startTime, endTime);

        return seconds.getSeconds();
    }
}
