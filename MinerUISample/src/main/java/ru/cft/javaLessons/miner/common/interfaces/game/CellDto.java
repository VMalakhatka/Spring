package ru.cft.javaLessons.miner.common.interfaces.game;

public record CellDto(boolean isMine, boolean isBlocked, boolean isOpened, int countMineAround) {
}
