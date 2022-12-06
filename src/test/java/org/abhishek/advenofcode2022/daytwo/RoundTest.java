package org.abhishek.advenofcode2022.daytwo;

import org.junit.jupiter.api.Test;

public class RoundTest {
	
	@Test
	void should_test_outcome_of_round() {
		
		Player opponent = new Player(PlayerMoveEnum.C);
		Player me = new Player(PlayerMoveEnum.Z);
		
		Round round = new Round(opponent, me);
		//System.out.println(round.calculateOutcome());
		//System.out.println("My score: " + round.calculateOutcome().score);
		
		//System.out.println("Round score: " + round.calculateRoundScore());
		System.out.println("Round Total score: " + round.calculateTotalScore());
	}
	
	@Test
	void should_create_a_round_object_for_part2_and_get_score_for_the_round() {
		String line = "A Y";
		GameMain gameMain = new GameMain(null);
		Round round = gameMain.createSingleRoundPartTwo(line);
		int totalScore = round.calculateTotalScore();
		System.out.println("TotalScore:" + totalScore);
	}
	
	@Test
	void should_create_a_round_object_for_part1_and_get_score_for_the_round() {
		String line = "A Y";
		GameMain gameMain = new GameMain(null);
		Round round = gameMain.createSingleRound(line);
		int totalScore = round.calculateTotalScore();
		System.out.println("TotalScore:" + totalScore);
	}

}
