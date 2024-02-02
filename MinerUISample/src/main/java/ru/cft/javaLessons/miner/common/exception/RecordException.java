package ru.cft.javaLessons.miner.common.exception;

import ru.cft.javaLessons.miner.common.exception.FormattedMessageException;

public class RecordException extends FormattedMessageException {
    public RecordException(Throwable cause) {
        super(cause);
    }

    public RecordException(String message) {
        super(message);
    }

    public RecordException(String message, Object... args) {
        super(message, args);
    }
}
