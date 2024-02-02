package ru.cft.javaLessons.miner.controller;

import ru.cft.javaLessons.miner.common.interfaces.controller.AbstractController;
import ru.cft.javaLessons.miner.common.interfaces.game.GameModel;
import ru.cft.javaLessons.miner.common.interfaces.game.GameState;
import ru.cft.javaLessons.miner.common.interfaces.game.GameType;
import ru.cft.javaLessons.miner.common.interfaces.record.GameRecord;
import ru.cft.javaLessons.miner.common.interfaces.record.RecordHolder;
import ru.cft.javaLessons.miner.common.interfaces.timer.GameTimer;

import java.time.Duration;

public class Controller extends AbstractController {

    public Controller(GameTimer gameTimer, GameModel gameModel, RecordHolder recordHolder) {
        super(gameTimer, gameModel, recordHolder);
    }

    @Override
    public void startNewGame(GameType gameType) {
        model.startNewGame(gameType);
        timer.reset();
    }

    @Override
    public GameState setFlag(int row, int column) {
        return model.setFlag(row, column);
    }

    @Override
    public GameState openCells(int row, int column) {
        start();
        return model.openCells(row, column);
    }

    @Override
    public GameState getState() {
        return model.getState();
    }

    @Override
    public Duration getCurrent() {
        return timer.getCurrent();
    }

    @Override
    public void reset() {
        timer.reset();
    }

    @Override
    public void start() {
        timer.start();
    }

    @Override
    public Duration stop() {
        return timer.stop();
    }

    @Override
    public boolean isNewRecord(GameRecord record) {
        return recordHolder.isNewRecord(record);
    }

    @Override
    public void setNewRecord(GameRecord record) {
        recordHolder.setNewRecord(record);
    }

    @Override
    public GameRecord getNovice() {
        return recordHolder.getNovice();
    }

    @Override
    public GameRecord getMedium() {
        return recordHolder.getMedium();
    }

    @Override
    public GameRecord getExpert() {
        return recordHolder.getExpert();
    }
}
