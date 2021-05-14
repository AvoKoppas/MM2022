package com.example.MM2022.repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameScoreRowMapper implements RowMapper<GameScore> {


    @Override
    public GameScore mapRow(ResultSet resultSet, int i) throws SQLException {
        GameScore result = new GameScore();
        result.setUserName(resultSet.getString("user_name"));
              result.setScore(resultSet.getInt("score"));
        return result;
    }
}
