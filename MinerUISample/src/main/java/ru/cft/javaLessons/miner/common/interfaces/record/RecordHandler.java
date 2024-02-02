package ru.cft.javaLessons.miner.common.interfaces.record;

import ru.cft.javaLessons.miner.model.records.GameBestRecords;

import java.util.Optional;

public interface RecordHandler {
    Optional<GameBestRecords> load();
    void save(GameBestRecords records);
}
