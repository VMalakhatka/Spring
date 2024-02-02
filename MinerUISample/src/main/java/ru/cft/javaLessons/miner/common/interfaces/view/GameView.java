package ru.cft.javaLessons.miner.common.interfaces.view;

import ru.cft.javaLessons.miner.common.interfaces.game.GameState;

public interface GameView {
    void show();
    void redraw(GameState gameState);
}
