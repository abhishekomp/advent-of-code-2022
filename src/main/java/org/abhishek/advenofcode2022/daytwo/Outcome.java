package org.abhishek.advenofcode2022.daytwo;

public enum Outcome {
	
	WIN(6),
	LOSE(0),
	DRAW(3);
	
	final int score;
	
	private Outcome(int score) {
		this.score = score;
	}
	

}
