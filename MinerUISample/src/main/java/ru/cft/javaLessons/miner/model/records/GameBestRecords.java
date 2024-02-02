package ru.cft.javaLessons.miner.model.records;


import ru.cft.javaLessons.miner.common.interfaces.game.GameType;
import ru.cft.javaLessons.miner.common.interfaces.record.GameRecord;
import ru.cft.javaLessons.miner.common.interfaces.record.RecordHandler;
import ru.cft.javaLessons.miner.common.interfaces.record.RecordHolder;

import java.io.Serializable;
import java.time.Duration;
import java.util.Optional;

public class GameBestRecords implements Serializable, RecordHolder {
    private GameRecord novice = new GameRecord("Kostya", Duration.ofSeconds(999L), GameType.NOVICE);
    private GameRecord medium = new GameRecord("Kostya", Duration.ofSeconds(999L), GameType.MEDIUM);
    private GameRecord expert = new GameRecord("Kostya", Duration.ofSeconds(999L), GameType.EXPERT);
    private final transient RecordHandler handler = new RecordHandlerImpl();

    public GameBestRecords() {
        Optional<GameBestRecords> fromFile = handler.load();
        if (fromFile.isPresent()) {
            this.novice = fromFile.get().getNovice();
            this.medium = fromFile.get().getMedium();
            this.expert = fromFile.get().getExpert();
        }
    }

    @Override
    public boolean isNewRecord(GameRecord record) {
        return switch (record.gameType()) {
            case NOVICE -> record.duration().compareTo(novice.duration()) < 0;
            case MEDIUM -> record.duration().compareTo(medium.duration()) < 0;
            case EXPERT -> record.duration().compareTo(expert.duration()) < 0;
        };
    }

    @Override
    public void setNewRecord(GameRecord record) {
        System.out.println("Попытка сохранить рекорд");
        switch (record.gameType()) {
            case NOVICE -> novice = record;
            case MEDIUM -> medium = record;
            case EXPERT -> expert = record;
        }
        handler.save(this);
    }

    @Override
    public GameRecord getNovice() {
        return novice;
    }

    @Override
    public GameRecord getMedium() {
        return medium;
    }

    @Override
    public GameRecord getExpert() {
        return expert;
    }
}
