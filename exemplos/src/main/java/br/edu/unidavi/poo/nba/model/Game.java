package br.edu.unidavi.poo.nba.model;

public class Game {

	private final int year;
	private final int month;
	private final int day;
	private String homeTeam;
	private String awayTeam;
	private int homePoints;
	private int awayPoints;

	Game(int year, int month, int day, String awayTeam, String homeTeam){
		this.year = year;
		this.month = month;
		this.day = day;
		this.awayTeam = awayTeam;
		this.homeTeam = homeTeam;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String getAwayTeam() {
		return awayTeam;
	}
	
	public String getHomeTeam() {
		return homeTeam;
	}
	
	public boolean isEqualTo(int year, int month, int day) {
		return getYear() == year && getMonth() == month && getDay() == day;
	}

	public boolean areTeams(String awayTeam, String homeTeam) {
		return getAwayTeam().equals(awayTeam) && getHomeTeam().equals(homeTeam);
	}

	public int getHomePoints() {
		return this.homePoints;
	}

	public void add2PointsToHomeTeam() {
		this.homePoints += 2;
	}

	public int getAwayPoints() {
		return this.awayPoints;
	}

	public void add1PointsToAwayTeam() {
		this.awayPoints += 1;
	}

	public boolean hadScore(int awayPoints, int homePoints) {
		return getAwayPoints() == awayPoints && getHomePoints() == homePoints;
	}

	public void setFinalScore(int awayPoints, int homePoints) {
		this.awayPoints = awayPoints;
		this.homePoints = homePoints;		
	}

	public boolean hasOneOf(String awayTeam, String homeTeam) {
		return getAwayTeam().equals(awayTeam) || getAwayTeam().equals(homeTeam) || getHomeTeam().equals(awayTeam) || getHomeTeam().equals(homeTeam);
 	}

	public void add2PointsToAwayTeam() {
		this.awayPoints += 2;
	}
}
