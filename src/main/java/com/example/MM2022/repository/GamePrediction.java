package com.example.MM2022.repository;

public class GamePrediction {
    private Integer gameId;
    private Integer gameNr;
    private Integer gameHome;
    private Integer gameAway;
    private String result;
    private Integer predictionId;
    private String userName;
    private Integer predictionHome;
    private Integer predictionAway;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getGameNr() {
        return gameNr;
    }

    public void setGameNr(Integer gameNr) {
        this.gameNr = gameNr;
    }

    public Integer getGameHome() {
        return gameHome;
    }

    public void setGameHome(Integer gameHome) {
        this.gameHome = gameHome;
    }

    public Integer getGameAway() {
        return gameAway;
    }

    public void setGameAway(Integer gameAway) {
        this.gameAway = gameAway;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Integer predictionId) {
        this.predictionId = predictionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPredictionHome() {
        return predictionHome;
    }

    public void setPredictionHome(Integer predictionHome) {
        this.predictionHome = predictionHome;
    }

    public Integer getPredictionAway() {
        return predictionAway;
    }

    public void setPredictionAway(Integer predictionAway) {
        this.predictionAway = predictionAway;
    }
}
