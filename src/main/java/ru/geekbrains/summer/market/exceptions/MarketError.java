package ru.geekbrains.summer.market.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class MarketError {
    private int status;
    private List<String> messages;
    private Date timestamp;

    public MarketError(String message) {
        this(List.of(message));
    }
    public MarketError(String ...  messages) {
        this(List.of(messages));
    }
    public MarketError(List<String> messages) {
        this.messages = messages;
        this.timestamp = new Date();
    }

}
