package br.edu.unidavi.poo.nba.model;

import org.junit.*;

public class GameTest {

	@Test
	public void awayTeamShouldBeMIN(){
		Game game = new Game(2017,10,22,"MIN","OKC");
		Assert.assertEquals("MIN",game.getAwayTeam());
	}
	
	@Test
	public void homeTeamShouldBeOKC(){
		Game game = new Game(2017,10,22,"MIN","OKC");
		Assert.assertEquals("OKC",game.getHomeTeam());
	}

	@Test
	public void dateShouldBeOctober22(){
		Game game = new Game(2017,10,22,"MIN","OKC");
		Assert.assertTrue(game.isEqualTo(2017, 10, 22));
	}

	@Test
	public void yearIsDifferent(){
		Game game = new Game(2016,10,22,"MIN","OKC");
		Assert.assertFalse(game.isEqualTo(2017, 10, 22));
	}

	@Test
	public void monthIsDifferent(){
		Game game = new Game(2017,11,22,"MIN","OKC");
		Assert.assertFalse(game.isEqualTo(2017, 10, 22));
	}

	@Test
	public void dayIsDifferent(){
		Game game = new Game(2017,10,21,"MIN","OKC");
		Assert.assertFalse(game.isEqualTo(2017, 10, 22));
	}

	@Test
	public void sameTeams(){
		Game game = new Game(2017,10,21,"MIN","OKC");
		Assert.assertTrue(game.areTeams("MIN","OKC"));
	}

	@Test
	public void notSameAwayTeam(){
		Game game = new Game(2017,10,21,"DET","OKC");
		Assert.assertFalse(game.areTeams("MIN","OKC"));
	}

	@Test
	public void notSameHomeTeam(){
		Game game = new Game(2017,10,21,"MIN","DET");
		Assert.assertFalse(game.areTeams("MIN","OKC"));
	}
	
	@Test
	public void shouldAdd2HomePoints(){
		Game game = new Game(2017,10,21,"MIN","OKC");
		game.add2PointsToHomeTeam();
		Assert.assertEquals(2,game.getHomePoints());
	}
	
	@Test
	public void shouldAdd2AwayPoints(){
		Game game = new Game(2017,10,21,"MIN","OKC");
		game.add2PointsToAwayTeam();
		Assert.assertEquals(2,game.getAwayPoints());
	}
	
}
