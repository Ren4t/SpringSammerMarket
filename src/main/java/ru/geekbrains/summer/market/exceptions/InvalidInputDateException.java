package ru.geekbrains.summer.market.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class InvalidInputDateException extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public InvalidInputDateException(List<String> messages) {
        super(messages.stream().collect(Collectors.joining(", ")));
        this.messages = messages;
    }
    public InvalidInputDateException(String message) {
        this(List.of(message));
    }
}
