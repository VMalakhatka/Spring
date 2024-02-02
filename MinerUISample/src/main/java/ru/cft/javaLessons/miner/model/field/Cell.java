package ru.cft.javaLessons.miner.model.field;

import ru.cft.javaLessons.miner.common.exception.GameException;

public record Cell(boolean isMine, boolean isBlocked, boolean isOpened, int countMineAround) {
    public Cell (Cell original, boolean isBlocked, boolean isOpened) {
        this(original.isMine(), isBlocked, isOpened, original.countMineAround);
    }

    public Cell block() {
        return new Cell(this, true, this.isOpened);
    }

    public Cell unBlock() {
        return new Cell(this, false, this.isOpened);
    }

    public Cell open() throws GameException {
        if (this.isBlocked) return this;
        return new Cell(this, false, true);
    }
}
