package org.example.common.interfaces;

import org.example.common.dto.GameState;

public interface GameModel {
    GameState mark(int raw, int column);
}

