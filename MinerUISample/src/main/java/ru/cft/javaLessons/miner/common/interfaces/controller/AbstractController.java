package ru.cft.javaLessons.miner.common.interfaces.controller;

import ru.cft.javaLessons.miner.common.interfaces.game.GameModel;
import ru.cft.javaLessons.miner.common.interfaces.record.RecordHolder;
import ru.cft.javaLessons.miner.common.interfaces.timer.GameTimer;

public abstract class AbstractController implements GameTimer, GameModel, RecordHolder {
    protected final GameTimer timer;
    protected final GameModel model;
    protected final RecordHolder recordHolder;

    public AbstractController(GameTimer timer, GameModel model, RecordHolder recordHolder) {
        this.timer = timer;
        this.model = model;
        this.recordHolder = recordHolder;
    }
}
