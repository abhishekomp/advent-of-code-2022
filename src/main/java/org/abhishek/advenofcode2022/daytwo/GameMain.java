package org.abhishek.advenofcode2022.daytwo;

import java.util.ArrayList;
import java.util.List;

public class GameMain {
	
	private List<Round> rounds;
	private final String filePath;
	
	public GameMain(String filePath) {
		this.filePath = filePath;
		this.rounds = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		//GameMain game = new GameMain("SampleInput.txt");
		GameMain game = new GameMain("RealInput.txt");
		game.playGame();
	}
	
	
	public List<Round> getRounds() {
		return rounds;
	}
	
	public void playGame() {
		List<Round> list = createRounds();
		int sum = list.stream().map(Round::calculateTotalScore).mapToInt(i->i).sum();
		System.out.println("Game score: " + sum);
	}
	

	public List<Round> createRounds() {
		FileReader reader = new FileReader(filePath);
		List<String> lines = reader.readLines();
		List<Round> rounds = new ArrayList<>();
		for(String line : lines) {
			//instantiate round object per line
			Round round = createSingleRoundPartTwo(line);
			rounds.add(round);
		}
		return rounds;
	}

	//Part 1
	public Round createSingleRound(String line) {
		String[] split = line.split(" ");
		Player opponent = new Player(PlayerMoveEnum.valueOf(split[0]));
		Player me = new Player(PlayerMoveEnum.valueOf(split[1]));
		Round round = new Round(opponent, me);
		return round;
	}
	
	//Part 2
	public Round createSingleRoundPartTwo(String line) {
		String[] split = line.split(" ");
		Player opponent = new Player(PlayerMoveEnum.valueOf(split[0]));

		String myMove = calculateMove(split[0], split[1]);
		Player me = new Player(PlayerMoveEnum.valueOf(myMove));
		Round round = new Round(opponent, me);
		return round;
	}

	//Part 2
	private String calculateMove(String opponentMove, String result) {
		String myMove = "";
		// TODO Auto-generated method stub
		if(result.equals("X")) {
			if(opponentMove.equals("A")) {
				myMove = "Z";
			} else if(opponentMove.equals("B")) {
				myMove = "X";
			} else {
				myMove = "Y";
			}
		} else if (result.equals("Y")) {
			if(opponentMove.equals("A")) {
				myMove = "X";
			} else if(opponentMove.equals("B")) {
				myMove = "Y";
			} else {
				myMove = "Z";
			}
		} else if (result.equals("Z")) {
			if(opponentMove.equals("A")) {
				myMove = "Y";
			} else if(opponentMove.equals("B")) {
				myMove = "Z";
			} else {
				myMove = "X";
			}
		}
		return myMove;
	}

}
