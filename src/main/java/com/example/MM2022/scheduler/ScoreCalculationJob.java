package com.example.MM2022.scheduler;

import com.example.MM2022.repository.MMRepository;
import com.example.MM2022.service.MMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ScoreCalculationJob {

    @Autowired
    private MMRepository mmRepository;
    @Autowired
    private MMService mmService;

    @Scheduled(fixedDelay = 3000)
    public void calculateScores() {
        List<String> userNames = mmRepository.getAllUserNames();
        for (String userName : userNames) {
            mmService.calculate(userName);
            System.out.println("Uuendab skoore");
        }
    }
}
