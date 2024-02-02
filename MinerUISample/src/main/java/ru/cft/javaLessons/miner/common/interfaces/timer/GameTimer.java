package ru.cft.javaLessons.miner.common.interfaces.timer;

import java.time.Duration;

public interface GameTimer {

    Duration getCurrent();

    void reset();

    void start();

    Duration stop();
}
