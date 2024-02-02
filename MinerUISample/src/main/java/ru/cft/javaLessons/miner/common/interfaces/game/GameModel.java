package ru.cft.javaLessons.miner.common.interfaces.game;

public interface GameModel {
    GameState setFlag(int row, int column);

    GameState openCells(int row, int column);

    GameState getState();

    void startNewGame(GameType gameType);
}
