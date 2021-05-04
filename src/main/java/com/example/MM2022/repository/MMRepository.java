package com.example.MM2022.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MMRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void insertPrediction(String userName, int gameId, int predictionA, int predictionB) {
        String sql = "INSERT INTO prediction (user_name, game_id, home, away) " +
                "VALUES (:name, :id, :predA, :predB)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", userName);
        paramMap.put("id", gameId);
        paramMap.put("predA", predictionA);
        paramMap.put("predB", predictionB);
        jdbcTemplate.update(sql, paramMap);

    }
    public void insertRealScore(int gameNr, int resultA, int resultB) {
        String sql = "INSERT INTO football_game (game_nr, home, away)" +
                "VALUES (:number, :resultA, :resultB)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("number", gameNr);
        paramMap.put("resultA", resultA);
        paramMap.put("resultB", resultB);
        jdbcTemplate.update(sql, paramMap);
    }
}
