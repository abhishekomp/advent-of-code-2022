package org.abhishek.advenofcode2022.daythree.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.abhishek.advenofcode2022.daythree.AlphabetMap;

public class PartTwoMain {

	public static void main(String[] args) {
		PartTwoMain partTwoMain = new PartTwoMain();
		partTwoMain.findBadgeFromGroupOfThree();

	}
	
	public void findBadgeFromGroupOfThree() {
		GroupsOfThreeCreator groupsCreator = new GroupsOfThreeCreator("RealInput.txt");
		//this returns a list of groups (each group is a list of 3 lines)
		List<ArrayList<String>> groups = groupsCreator.createGroups();
		
		int sumOfPriorites = 0;
		
		//Now for each group we need to find the common element (each group has 3 strings)
		for(ArrayList<String> group : groups) {
			char c = findCommonCharacter(group);
			Integer priority = AlphabetMap.getAlphaberMap().get(c);
			sumOfPriorites = sumOfPriorites + priority;
		}
		System.out.println("Final Priority: " + sumOfPriorites);
	}

	private char findCommonCharacter(ArrayList<String> group) {
		List<Character> commonCharacters = findListOfCommonCharacters(group.get(0), group.get(1));
		
		Character matchingChar = commonCharacters.stream()
			.sorted()
			.filter(c -> group.get(2).chars().mapToObj(e->(char)e).collect(Collectors.toList()).contains(c))
			.findFirst()
			.orElse(' ');
		return matchingChar;
	}

	private List<Character> findListOfCommonCharacters(String string, String string2) {
		List<Character> charListOne = string.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		List<Character> charListTwo = string2.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		List<Character> commonCharList = charListOne.stream()
			.sorted()
			.filter(c -> charListTwo.contains(c))
			.collect(Collectors.toList());
		return commonCharList;
	}

}
