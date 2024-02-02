package ru.cft.javaLessons.miner.view;

import ru.cft.javaLessons.miner.common.interfaces.controller.AbstractController;
import ru.cft.javaLessons.miner.common.interfaces.game.CellDto;
import ru.cft.javaLessons.miner.common.interfaces.game.GameResult;
import ru.cft.javaLessons.miner.common.interfaces.game.GameState;
import ru.cft.javaLessons.miner.common.interfaces.record.GameRecord;
import ru.cft.javaLessons.miner.common.interfaces.view.GameView;

import java.time.Duration;

public class View implements GameView {
    private final AbstractController controller;
    private MainWindow mainWindow;
    private EndingWindow winWindow;
    private EndingWindow loseWindow;
    private SettingsWindow settingsWindow;
    private HighScoresWindow highScoresWindow;
    private Thread timer;

    public View(AbstractController controller) {
        this.controller = controller;
        createGui();
    }

    private void createGui() {
        createMainWindow();
        createLoseWindow();
        createSettingsWindow();
        createWinWindow();
        createHighScoresWindow();
        show();
    }

    private void createMainWindow() {
        GameState state = controller.getState();
        this.mainWindow = new MainWindow();

        mainWindow.setNewGameMenuAction(e -> settingsWindow.setVisible(true));
        mainWindow.setSettingsMenuAction(e -> settingsWindow.setVisible(true));
        mainWindow.setHighScoresMenuAction(e -> highScoresWindow.setVisible(true));
        mainWindow.setExitMenuAction(e -> mainWindow.dispose());

        mainWindow.createGameField(state.field().length, state.field()[0].length);
        mainWindow.setCellListener((x, y, buttonType) -> {
            GameState gameState = switch (buttonType) {
                case LEFT_BUTTON -> {
                    timer = startTimer();
                    yield controller.openCells(x, y);
                }
                case RIGHT_BUTTON -> controller.setFlag(x, y);
                case MIDDLE_BUTTON -> null; //TODO реализовать открытие ячеек по нажатию средней кнопки
            };
            redraw(gameState);
        });
    }

    private Thread startTimer() { // TODO реализацию можно заменить на Timer https://developer.alexanderklimov.ru/android/java/timer.php
        Thread t = new Thread(
                () -> {
                    while (true) {
                        mainWindow.setTimerValue((int) controller.getCurrent().toSeconds());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignore) {
                        }
                    }
                },
                "timer"
        );
        t.setDaemon(true);
        t.start();
        return t;
    }

    private void createSettingsWindow() {
        this.settingsWindow = new SettingsWindow(mainWindow);
        settingsWindow.setNewGameListener(e -> {
            timer.interrupt();
            controller.startNewGame(settingsWindow.getGameType());
            disposeAll();
            createGui();
        });
    }

    private void createLoseWindow() {
        loseWindow = new EndingWindow(mainWindow, "Lose");
        loseWindow.setExitListener(e -> System.exit(0));
        loseWindow.setNewGameListener(e -> settingsWindow.setVisible(true));
    }

    private void createWinWindow() {
        winWindow = new EndingWindow(mainWindow, "Win");
        winWindow.setExitListener(e -> System.exit(0));
        winWindow.setNewGameListener(e -> settingsWindow.setVisible(true));
    }

    private void createRecordWindow(Duration res, GameState gameState) {
        RecordsWindow recordsWindow = new RecordsWindow(mainWindow);
        recordsWindow.setNameListener(name -> controller.setNewRecord(new GameRecord(name, res, gameState.type())));
        recordsWindow.setVisible(true);
    }

    private void createHighScoresWindow() {
        this.highScoresWindow = new HighScoresWindow(mainWindow);
        GameRecord nov = controller.getNovice();
        highScoresWindow.setNoviceRecord(nov.playerName(), (int) nov.duration().toSeconds());
        GameRecord med = controller.getMedium();
        highScoresWindow.setMediumRecord(med.playerName(), (int) med.duration().toSeconds());
        GameRecord exp = controller.getExpert();
        highScoresWindow.setExpertRecord(exp.playerName(), (int) exp.duration().toSeconds());
    }

    @Override
    public void show() {
        mainWindow.setVisible(true);
    }

    @Override
    public void redraw(GameState gameState) {
        printAsTable(gameState);
        mainWindow.redrawState(gameState);
        Duration res = controller.getCurrent();
        if (gameState.result().equals(GameResult.LOSE)) {
            controller.stop();
            mainWindow.setEnabled(false);
            loseWindow.setEnabled(true);
            loseWindow.setVisible(true);
        }
        if (gameState.result().equals(GameResult.WIN)) {
            controller.stop();

            if (controller.isNewRecord(new GameRecord("", res, gameState.type()))) {
                createRecordWindow(res, gameState);
            }
            mainWindow.setEnabled(false);
            winWindow.setEnabled(true);
            winWindow.setVisible(true);
        }
    }


    private void printAsTable(GameState gameState) {
        for (CellDto[] row : gameState.field()) {
            for (CellDto c : row) {
                String cellSymbol = c.isOpened() ? "O" : (c.isMine() ? "M" : "C");
                System.out.print(cellSymbol + " ");
            }
            System.out.println();
        }
        System.out.println(gameState.result());
        System.out.println();
    }

    private void disposeAll() {
        timer = null;
        mainWindow.dispose();
    }
}
