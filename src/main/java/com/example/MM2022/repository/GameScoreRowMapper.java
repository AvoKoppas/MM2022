package com.example.MM2022.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameScoreRowMapper implements RowMapper<GameScore> {


    @Override
    public GameScore mapRow(ResultSet resultSet, int i) throws SQLException {
        GameScore result = new GameScore();
        //result.setGameId(resultSet.getInt("f_id"));
        //result.setGameNr(resultSet.getInt("game_nr"));
        //result.setGameHome(resultSet.getInt("f_home"));
        //result.setGameAway(resultSet.getInt("f_away"));
        //result.setResult(resultSet.getString("result"));
        //result.setPredictionId(resultSet.getInt("p_id"));
        result.setUserName(resultSet.getString("user_name"));
        //result.setPredictionHome(resultSet.getInt("p_home"));
        //result.setPredictionAway(resultSet.getInt("p_away"));
        result.setScore(resultSet.getInt("score"));
        return result;
    }
}