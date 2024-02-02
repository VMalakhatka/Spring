package ru.cft.javaLessons.miner.app;

import ru.cft.javaLessons.miner.common.exception.GameException;
import ru.cft.javaLessons.miner.common.interfaces.game.GameModel;
import ru.cft.javaLessons.miner.common.interfaces.game.GameType;
import ru.cft.javaLessons.miner.common.interfaces.record.RecordHolder;
import ru.cft.javaLessons.miner.common.interfaces.timer.GameTimer;
import ru.cft.javaLessons.miner.common.interfaces.view.GameView;
import ru.cft.javaLessons.miner.controller.Controller;
import ru.cft.javaLessons.miner.model.field.Field;
import ru.cft.javaLessons.miner.model.records.GameBestRecords;
import ru.cft.javaLessons.miner.model.time.Timer;
import ru.cft.javaLessons.miner.view.View;

import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        RecordHolder recordHolder = new GameBestRecords();
        GameTimer gameTimer = new Timer();
        Optional<GameModel> opModel = createModel();
        if (opModel.isEmpty()) System.exit(1);
        Controller controller = new Controller(gameTimer, opModel.get(), recordHolder);
        GameView gameView = new View(controller);
        gameView.show();
    }

    private static Optional<GameModel> createModel() {
        try {
            return Optional.of(new Field(GameType.DEFAULT));
        } catch (GameException e) {
            System.err.println("Ошибка создания поля");
            System.err.println(e);
        }
        return Optional.empty();
    }
}
