package ru.geekbrains.summer.market.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class MarketError {
    private int status;
    private List<String> message;
    private Date timestamp;

    public MarketError(int status, String message) {
        this(List.of(message));
        this.status = status;
    }
    public MarketError(String message) {
        this(List.of(message));
    }
    public MarketError(String ...  messages) {
        this(List.of(messages));
    }
    public MarketError(List<String> message) {
        this.message = message;
        this.timestamp = new Date();
    }

}
