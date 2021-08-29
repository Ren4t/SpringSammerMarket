package ru.geekbrains.summer.market.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
@Data
@NoArgsConstructor
public class Statistic {
    private HashMap<String,Long> statisticMap;

    @PostConstruct
    public void init(){
        statisticMap = new HashMap<>();

    }

    public void buildStatistic(String service,Long duration){
        if(statisticMap.containsKey(service)){
            Long res = statisticMap.get(service) + duration;
            statisticMap.put(service,res);
            return;
        }
        statisticMap.put(service,duration);
    }
}
