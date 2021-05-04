package com.example.MM2022.repository;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreRowMapper implements RowMapper<GamePrediction> {


    @Override
    public GamePrediction mapRow(ResultSet resultSet, int i) throws SQLException {
        GamePrediction result = new GamePrediction();
        result.setGameId(resultSet.getInt("f_id"));
        result.setGameNr(resultSet.getInt("game_nr"));
        result.setGameHome(resultSet.getInt("f_home"));
        result.setGameAway(resultSet.getInt("f_away"));
        result.setResult(resultSet.getString("result"));
        result.setPredictionId(resultSet.getInt("p_id"));
        result.setUserName(resultSet.getString("user_name"));
        result.setPredictionHome(resultSet.getInt("p_home"));
        result.setPredictionAway(resultSet.getInt("p_away"));
        return result;
    }
}
