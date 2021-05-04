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

    public void calculateScore() {

    }

    public int getPrediction(String userName, int gameId) {
        String sql = "SELECT home, away FROM prediction " +
                "WHERE user_name=:muutuja1, game_id = :gameId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        paramMap.put("gameId", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }

    public int getResultHome(String gameId) {
        String sql = "SELECT home FROM football_games " +
                "WHERE game_id = :gameId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameId", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }
}
