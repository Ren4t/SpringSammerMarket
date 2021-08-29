package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.OrderDto;
import ru.geekbrains.summer.market.exceptions.InvalidInputDataException;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.User;
import ru.geekbrains.summer.market.services.OrderService;
import ru.geekbrains.summer.market.services.UserService;
import ru.geekbrains.summer.market.utils.Statistic;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final Statistic statistic;

    @GetMapping
    public HashMap<String,Long> viewStatistic(){
        return statistic.getStatisticMap();
    }
}
