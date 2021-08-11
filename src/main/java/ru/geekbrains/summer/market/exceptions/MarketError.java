package ru.geekbrains.summer.market.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class MarketError {
    private int status;
    private String message;
    private Date timestamp;

    public MarketError(String message) {
       this(404, message);
    }

    public MarketError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
