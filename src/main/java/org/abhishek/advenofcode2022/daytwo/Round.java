package org.abhishek.advenofcode2022.daytwo;

public class Round {
	
	private Player opponent;
	private Player me;
	
	public Round(Player opponent, Player me) {
		this.opponent = opponent;
		this.me = me;
	}

	public Player getOpponent() {
		return opponent;
	}

	public Player getMe() {
		return me;
	}

	private Outcome calculateOutcome() {
		Outcome outcome;
		if(((me.getMove() == PlayerMoveEnum.X) && (opponent.getMove() == PlayerMoveEnum.C)) ||
			((me.getMove() == PlayerMoveEnum.Z) && (opponent.getMove() == PlayerMoveEnum.B)) ||
			((me.getMove() == PlayerMoveEnum.Y) && (opponent.getMove() == PlayerMoveEnum.A))
				) {
			outcome = Outcome.WIN;
		} else if (((me.getMove() == PlayerMoveEnum.X) && (opponent.getMove() == PlayerMoveEnum.A)) ||
				((me.getMove() == PlayerMoveEnum.Z) && (opponent.getMove() == PlayerMoveEnum.C)) ||
				((me.getMove() == PlayerMoveEnum.Y) && (opponent.getMove() == PlayerMoveEnum.B))) {
			outcome = Outcome.DRAW;
		} else {
			outcome = Outcome.LOSE;
		}
		return outcome;
	}
	
	public int calculateRoundScore() {
		return calculateOutcome().score;
	}
	
	public int calculateTotalScore() {
		//calculateRoundScore()
		int totalScore = me.getMove().point + calculateRoundScore();
		return totalScore;
	}

}
