package br.edu.unidavi.poo.nba.model;

public class Games {

	private Game[] repository = new Game[20];
	private int nextIndex = 0;
	
	public Game[] findByDate(int year, int month, int day) {
		int index = 0;
		int counter = 0;
		for (int i=0; i< repository.length; i++){
			if (repository[i] != null && repository[i].isEqualTo(year,month,day)){
				counter ++;
			}
		}
		Game[] result = new Game[counter];
		for (int i=0; i< repository.length; i++){
			if (repository[i] != null && repository[i].isEqualTo(year,month,day)){
				result[index++] = repository[i];
			}
		}
		return result;
	}

	public void schedule(int year, int month, int day, String awayTeam, String homeTeam) {
		for (Game game: repository){
			if (game != null && game.hasOneOf(awayTeam, homeTeam)) return;
		}
		repository[nextIndex++] = new Game(year, month, day, awayTeam, homeTeam);
	}

	public void reschedule(int fromYear, int fromMonth, int fromDay, String awayTeam, String homeTeam, int toYear, int toMonth, int toDay) {
		int index = 0;
		for (Game game: repository){
			if (game != null && game.isEqualTo(fromYear, fromMonth, fromDay) && game.areTeams(awayTeam, homeTeam)){
				repository[index] = new Game(toYear, toMonth, toDay, awayTeam, homeTeam); 
			}
			index++;
		}
	}

	public void add2Points(int year, int month, int day, String awayTeam, String homeTeam) {
		int index = 0;
		for (Game game: repository){
			if (game != null && game.isEqualTo(year, month, day) && game.areTeams(awayTeam, homeTeam)){
				repository[index].add2PointsToHomeTeam(); 
			}
			index++;
		}
	}

	public void add1Points(int year, int month, int day, String awayTeam, String homeTeam) {
		int index = 0;
		for (Game game: repository){
			if (game != null && game.isEqualTo(year, month, day) && game.areTeams(awayTeam, homeTeam)){
				repository[index].add1PointsToAwayTeam(); 
			}
			index++;
		}
	}

	public void setFinalScore(int year, int month, int day, String awayTeam, String homeTeam, int awayPoints, int homePoints) {
		int index = 0;
		for (Game game: repository){
			if (game != null && game.isEqualTo(year, month, day) && game.areTeams(awayTeam, homeTeam)){
				repository[index].setFinalScore(awayPoints, homePoints); 
			}
			index++;
		}
	}

}
