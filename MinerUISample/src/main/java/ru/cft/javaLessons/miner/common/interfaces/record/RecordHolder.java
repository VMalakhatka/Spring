package ru.cft.javaLessons.miner.common.interfaces.record;

public interface RecordHolder {
    boolean isNewRecord(GameRecord record);
    void setNewRecord(GameRecord record);
    GameRecord getNovice();
    GameRecord getMedium();
    GameRecord getExpert();
}
