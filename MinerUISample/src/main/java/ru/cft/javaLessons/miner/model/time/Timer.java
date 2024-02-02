package ru.cft.javaLessons.miner.model.time;

import ru.cft.javaLessons.miner.common.interfaces.timer.GameTimer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Timer implements GameTimer {
    private LocalDateTime start;
    private Duration end;

    @Override
    public Duration getCurrent() {
        return start == null ? Duration.ZERO : Objects.requireNonNullElse(end, Duration.between(start, LocalDateTime.now()));
    }

    @Override
    public void reset() {
        start = null;
        end = null;
    }

    @Override
    public void start() {
        start = Objects.requireNonNullElse(start, LocalDateTime.now());
    }

    @Override
    public Duration stop() {
        end = getCurrent();
        return end;
    }

}
