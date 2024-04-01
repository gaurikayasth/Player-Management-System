package com.gauri.models;

public class Player {
	int playerId;
	String playerName;
	String team;
	String jerseyNum;
	int runs;
	int wickets;
	int matchPlayed;
	
	public Player() {
		this.playerId = 0;
		this.playerName = " ";
		this.team = " ";
		this.jerseyNum = " ";
		this.runs = 0;
		this.wickets = 0;
		this.matchPlayed = 0;
	}

	public Player(int playerId, String playerName, String team, String jerseyNum, int runs, int wickets,
			int matchPlayed) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.team = team;
		this.jerseyNum = jerseyNum;
		this.runs = runs;
		this.wickets = wickets;
		this.matchPlayed = matchPlayed;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getJerseyNum() {
		return jerseyNum;
	}

	public void setJerseyNum(String jerseyNum) {
		this.jerseyNum = jerseyNum;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}
	
}
