package org.abhishek.advenofcode2022.daytwo;

public class Player {
	
	private final PlayerMoveEnum move;
	
	public Player(PlayerMoveEnum move) {
		this.move = move;
	}

	public PlayerMoveEnum getMove() {
		return move;
	}

}
