package ru.cft.javaLessons.miner.model.records;

import ru.cft.javaLessons.miner.common.exception.RecordException;
import ru.cft.javaLessons.miner.common.interfaces.record.RecordHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class RecordHandlerImpl implements RecordHandler {
    private static final Path PATH = Path.of("RecordTable");

    @Override
    public Optional<GameBestRecords> load() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(PATH.toFile()))) {
            Object o = input.readObject();
            if (o instanceof GameBestRecords recs) {
                return Optional.of(recs);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Не удалось загрузить файл рекордов");
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void save(GameBestRecords records) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(PATH.toFile()))) {
            if (!PATH.toFile().exists()) Files.createFile(PATH);
            output.writeObject(records);
            System.out.println("Записано " + PATH.toAbsolutePath());
        } catch (IOException e) {
            throw new RecordException("Не удалось сохранить рекорды ", e);
        }
    }
}
