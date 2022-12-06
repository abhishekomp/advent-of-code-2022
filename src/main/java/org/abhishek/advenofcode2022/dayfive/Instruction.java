package org.abhishek.advenofcode2022.dayfive;

public class Instruction {
	
	private final int numOfCratesToMove;
	private final int sourceCrateStack;
	private final int targetCrateStack;
	
	public Instruction(int numOfCratesToMove, int sourceCrateStack, int targetCrateStack) {
		this.numOfCratesToMove = numOfCratesToMove;
		this.sourceCrateStack = sourceCrateStack;
		this.targetCrateStack = targetCrateStack;
	}

	public int getNumOfCratesToMove() {
		return numOfCratesToMove;
	}

	public int getSourceCrateStack() {
		return sourceCrateStack;
	}

	public int getTargetCrateStack() {
		return targetCrateStack;
	}

	@Override
	public String toString() {
		return "Instruction [numOfCratesToMove=" + numOfCratesToMove + ", sourceCrateStack=" + sourceCrateStack
				+ ", targetCrateStack=" + targetCrateStack + "]";
	}
}
