package ru.cft.javaLessons.miner.common.interfaces.record;


import ru.cft.javaLessons.miner.common.interfaces.game.GameType;

import java.io.Serializable;
import java.time.Duration;

public record GameRecord(String playerName, Duration duration, GameType gameType) implements Serializable {
}
