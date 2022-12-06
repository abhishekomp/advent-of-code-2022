package org.abhishek.advenofcode2022.dayfive;

import java.util.ArrayList;
import java.util.List;

public class CrateStackRearranger {
	
	public static void main(String[] args) {
		CrateStackRearranger rearranger = new CrateStackRearranger();
		rearranger.rearrangeCratesStack();
	}
	
	public void rearrangeCratesStack() {
		//get list of CrateStacks
		//String[] exampleStrings = {"1 [Z] [N]", "2 [M] [C] [D]", "3 [P]"};
		
		String[] exampleStrings = {"1 [D] [L] [V] [T] [M] [H] [F]",
				"2 [H] [Q] [G] [J] [C] [T] [N] [P]",
				"3 [R] [S] [D] [M] [P] [H]",
				"4 [L] [B] [V] [F]",
				"5 [N] [H] [G] [L] [Q]",
				"6 [W] [B] [D] [G] [R] [M] [P]",
				"7 [G] [M] [N] [R] [C] [H] [L] [Q]",
				"8 [C] [L] [W]",
				"9 [R] [D] [L] [Q] [J] [Z] [M] [T]"
		};
		
		List<CratesStack> crateStacks = new ArrayList<>();
		CrateStackCreator creator = new CrateStackCreator();
		for(int i = 0; i < exampleStrings.length; i++) {
			CratesStack crateStack = creator.createStackFromLine(exampleStrings[i]);
//			System.out.println("Top element of CrateStack with id: " + crateStack.getStackId() 
//					+ " is: " + crateStack.getTopElement());
			crateStacks.add(crateStack);
		}
		//Read all processing lines
		//ProcessingLineReader reader = new ProcessingLineReader("SampleInput.txt");
		ProcessingLineReader reader = new ProcessingLineReader("RealInput.txt");
		List<String> processingLines = reader.readProcessingLines();
		
		//Apply processing lines on stacks
		for(String processingLine : processingLines) {
			Instruction instruction = reader.generateInstructionFromProcessingLine(processingLine);
			applyInstructionPartTwo(crateStacks, instruction);
		}
		//System.out.println("After applying instruction: " + processingLine + " top of source stack: " + crateStacks.get(instruction.getSourceCrateStack() - 1).getTopElement());
		System.out.println("Displaying top of all CrateStacks");
		for(CratesStack cratesStack : crateStacks) {
			System.out.println(cratesStack.getTopElement());
		}
	}
	
	private void applyInstructionPartTwo(List<CratesStack> crateStacks, Instruction instruction) {
		char[] poppedCrates = new char[instruction.getNumOfCratesToMove()];
		for(int i = 0; i < instruction.getNumOfCratesToMove(); i++) {
			//pop all and store it in an array and then reverse the array
			char removeCrate = crateStacks.get(instruction.getSourceCrateStack() - 1).removeCrate();
			poppedCrates[i] = removeCrate;
		}
		//Now reverse the array
		char[] reverse = reverse(poppedCrates, poppedCrates.length);
		for(int i = 0; i < reverse.length; i++) {
			crateStacks.get(instruction.getTargetCrateStack()-1).addCrate(reverse[i]);
		}
		
	}
	
	private char[] reverse(char a[], int n)
    {
        char[] b = new char[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

	private void applyInstructionPartOne(List<CratesStack> crateStacks, Instruction instruction) {
		for(int i = 0; i < instruction.getNumOfCratesToMove(); i++) {
			char removeCrate = crateStacks.get(instruction.getSourceCrateStack() - 1).removeCrate();
			crateStacks.get(instruction.getTargetCrateStack()-1).addCrate(removeCrate);
		}
	}

}
