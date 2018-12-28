package br.edu.unidavi.poo.nba.model;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("unused")
public class GamesTest {

	@Test
	public void shouldScheduleAGame() {
		boolean expected = true;
		boolean actual;
		Games games = new Games();
		games.schedule(2017, 10, 21, "DET", "NYK");
		Game[] gamesOnOct21 = games.findByDate(2017, 10, 21);
		actual = gamesOnOct21.length == 1;
		actual = actual && gamesOnOct21[0].areTeams("DET", "NYK");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldNotScheduleAGameCauseTeamPlayOnSameDate() {
		boolean expected = true;
		boolean actual;
		Games games = new Games();
		games.schedule(2017, 10, 21, "DET", "NYK");
		games.schedule(2017, 10, 21, "CHA", "DET");
		Game[] gamesOnOct21 = games.findByDate(2017, 10, 21);
		actual = gamesOnOct21.length == 1;
		Assert.assertEquals("expected just one game", 1, gamesOnOct21.length);
		actual = actual && gamesOnOct21[0].areTeams("DET", "NYK");
		Assert.assertEquals("DET at NYK",expected, actual);
	}
	
	@Test
	public void shouldFind2GamesOnOct17() {
		Games games = new Games();
		int expected = 2;
		int actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "ClE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
		}
		when: {
			Game[] gamesOnOct17 = games.findByDate(2017, 10, 17);
			actual = gamesOnOct17.length;
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
	}
	
	@Test
	public void shouldFindBOSxCLEOnOct17() {
		Games games = new Games();
		boolean expected = true;
		boolean actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "CLE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
		}
		when: {
			Game[] gamesOnOct17 = games.findByDate(2017, 10, 17);
			actual = false;
			for (Game game: gamesOnOct17){
				if (game.areTeams("BOS","CLE")){
					actual = true;
				}
			}
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void shouldNotFindCHAxDETOnOct17() {
		Games games = new Games();
		boolean expected = false;
		boolean actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "CLE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
			games.schedule(2017, 10, 18, "CHA", "DET");
		}
		when: {
			Game[] gamesOnOct17 = games.findByDate(2017, 10, 17);
			actual = false;
			for (Game game: gamesOnOct17){
				if (game.areTeams("CHA","DET")){
					actual = true;
				}
			}
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
	}
	
	@Test
	public void shouldRescheduleToOct19CHAAtDET(){
		Games games = new Games();
		boolean expected = true;
		boolean actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "CLE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
			games.schedule(2017, 10, 18, "CHA", "DET");
		}
		when: {
			games.reschedule(2017,10,18,"CHA","DET", 2017,10,19);
			Game[] gamesOnOct19 = games.findByDate(2017, 10, 19);
			actual = gamesOnOct19.length == 1;
			Game[] gamesOnOct18 = games.findByDate(2017, 10, 18);
			actual = actual && gamesOnOct18.length == 0;
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
		
	}
	
	@Test
	public void shouldNotRescheduleToOct20CHAAtDETCauseAnotherCHAGame(){
		Assert.fail("not implemented yet");
	}	

	@Test
	public void shouldNotRescheduleToOct20CHAAtDETCauseAnotherDETGame(){
		Assert.fail("not implemented yet");
	}	
	
	@Test
	public void shouldAdd3PointsToAwayTeamOnOct18CHAAtDET(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldAdd3PointsToHomeTeamOnOct18CHAAtDET(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldAdd2PointsToAwayTeamOnOct18CHAAtDET(){
		Assert.fail("not implemented yet");
	}
	
	@Test
	public void shouldAdd2PointsToHomeTeamOnOct18CHAAtDET(){
		Games games = new Games();
		int expected = 2;
		int actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "CLE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
			games.schedule(2017, 10, 18, "CHA", "DET");
		}
		when: {
			games.add2Points(2017,10,18,"CHA","DET");
			Game[] gamesOnOct18 = games.findByDate(2017, 10, 18);
			actual = gamesOnOct18[0].getHomePoints();
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
		
	}	

	@Test
	public void shouldAdd1PointsToHomeTeamOnOct18CHAAtDET(){
		Assert.fail("not implemented yet");
	}
	
	@Test
	public void shouldAdd1PointsToAwayTeamOnOct18CHAAtDET(){
		Games games = new Games();
		int expected = 1;
		int actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "CLE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
			games.schedule(2017, 10, 18, "CHA", "DET");
		}
		when: {
			games.add1Points(2017,10,18,"CHA","DET");
			Game[] gamesOnOct18 = games.findByDate(2017, 10, 18);
			actual = gamesOnOct18[0].getAwayPoints();
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
		
	}	

	@Test
	public void shouldSetFinalScoreToCHAAtDETOnOct18(){
		Games games = new Games();
		boolean expected = true;
		boolean actual;
		given: {
			games.schedule(2017, 10, 17, "BOS", "CLE");
			games.schedule(2017, 10, 17, "HOU", "GSW");
			games.schedule(2017, 10, 18, "CHA", "DET");
		}
		when: {
			games.setFinalScore(2017,10,18,"CHA","DET",80,92);
			Game[] gamesOnOct18 = games.findByDate(2017, 10, 18);
			actual = gamesOnOct18[0].hadScore(80,92);
		}
		then: {
			Assert.assertEquals(expected, actual);
		}
	}
	
	
	@Test
	public void shouldNotSetFinalScoreWithNegativeHomePoints(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldNotSetFinalScoreWithNegativeAwayPoints(){
		Assert.fail("not implemented yet");
	}
	
	@Test
	public void shouldFindDETAsWinnerOnOct18(){
		Assert.fail("not implemented yet");
	}
	
	@Test
	public void shouldFindCHAAsLoserOnOct18(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldFindBiggestDifferenceOnOct18(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldFindSmallestDifferenceOnOct18(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldFindMaximumPontuationOnOct18(){
		Assert.fail("not implemented yet");
	}

	@Test
	public void shouldFindMinimumPontuationOnOct18(){
		Assert.fail("not implemented yet");
	}
	
}
