package ru.cft.javaLessons.miner.common.exception;

import ru.cft.javaLessons.miner.common.exception.FormattedMessageException;

public class GameException extends FormattedMessageException {
    public GameException(Throwable cause) {
        super(cause);
    }

    public GameException(String message) {
        super(message);
    }

    public GameException(String message, Object... args) {
        super(message, args);
    }
}
