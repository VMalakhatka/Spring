package ru.cft.javaLessons.miner.common.interfaces.game;

public record GameState(CellDto[][] field, int flagCount, GameResult result, GameType type) {

}
