package org.abhishek.advenofcode2022.dayfive;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CrateStackCreatorTest {
	
	CrateStackCreator creator = new CrateStackCreator();
	
	@Test
	void should_return_a_fully_initialized_CratesStack() {
		char[] charArray = {'Z', 'N'};
		String line = "1 [Z] [N]";
		CratesStack createStack = creator.createStack(1, charArray);
		System.out.println("StackId: " + createStack.getStackId());
		//System.out.println(createStack.getTopElement());
		
		System.out.println(createStack.removeCrate());
		System.out.println(createStack.getTopElement());
		System.out.println(createStack.removeCrate());
		//System.out.println(createStack.getTopElement());
	}
	
	@Test
	void should_return_fully_initialized_CratesStack_from_line() {
		//String line = "1 [Z] [N]";
		//String line = "2 [M] [C] [D]";
		//String line = "3 [P]";
		
		String[] exampleStrings = {"1 [Z] [N]", "2 [M] [C] [D]", "3 [P]"};
		//String[] exampleStrings = {"1 [Z] [N]"};
		
		String[] exampleStringsReal = {"1 [D] [L] [V] [T] [M] [H] [F]",
				"2 [H] [Q] [G] [J] [C] [T] [N] [P]",
				"3 [R] [S] [D] [M] [P] [H]",
				"4 [L] [B] [V] [F]",
				"5 [N] [H] [G] [L] [Q]",
				"6 [W] [B] [D] [G] [R] [M] [P]",
				"7 [G] [M] [N] [R] [C] [H] [L] [Q]",
				"8 [C] [L] [W]",
				"9 [R] [D] [L] [Q] [J] [Z] [M] [T]"
		};
		
		//String line = "1 [D] [L] [V] [T] [M] [H] [F]";
		//String line = "2 [H] [Q] [G] [J] [C] [T] [N] [P]";
		//String line = "3 [R] [S] [D] [M] [P] [H]";
		//String line = "4 [L] [B] [V] [F]";
		//String line = "5 [N] [H] [G] [L] [Q]";
		//String line = "6 [W] [B] [D] [G] [R] [M] [P]";
		//String line = "7 [G] [M] [N] [R] [C] [H] [L] [Q]";
		//String line = "8 [C] [L] [W]";
		//String line = "9 [R] [D] [L] [Q] [J] [Z] [M] [T]";
		for(int i = 0; i < exampleStrings.length; i++) {
			CratesStack createStackFromLine = creator.createStackFromLine(exampleStrings[i]);
			System.out.println("Top element of CrateStack: " + createStackFromLine.getTopElement());
		}
		
	}
	
	@Test
	void should_return_fully_initialized_ListOfCratesStack_from_line() {
		String[] exampleStrings = {"1 [Z] [N]", "2 [M] [C] [D]", "3 [P]"};
		for(int i = 0; i < exampleStrings.length; i++) {
			CratesStack createStackFromLine = creator.createStackFromLine(exampleStrings[i]);
			System.out.println("Top element of CrateStack with id: " + createStackFromLine.getStackId() 
					+ " is: " + createStackFromLine.getTopElement());
		}
		
	}
	
	@Test
	void should_return_fully_initialized_ListOfCratesStack_from_linePart1() {
		String processLine = "move 1 from 2 to 1";
		List<CratesStack> crateStacks = new ArrayList<>();
		String[] exampleStrings = {"1 [Z] [N]", "2 [M] [C] [D]", "3 [P]"};
		for(int i = 0; i < exampleStrings.length; i++) {
			CratesStack crateStack = creator.createStackFromLine(exampleStrings[i]);
			System.out.println("Top element of CrateStack with id: " + crateStack.getStackId() 
					+ " is: " + crateStack.getTopElement());
			crateStacks.add(crateStack);
		}
		
	}
	
}
