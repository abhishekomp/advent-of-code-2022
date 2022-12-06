package org.abhishek.advenofcode2022.daythree;

import java.util.List;
import java.util.stream.Collectors;

public class FindFirstCharacter {

	public static void main(String[] args) {
		String firstStr = "vJrwpWtwJgWr";
		String secondStr = "hcsFMMfFFhFp";
		
		List<Character> charListOne = firstStr.chars()
			    .mapToObj(e->(char)e).collect(Collectors.toList());
		
		List<Character> charListTwo = secondStr.chars()
			    .mapToObj(e->(char)e).collect(Collectors.toList());
		
		Character character = charListOne.stream().sorted()
			.filter(c -> charListTwo.contains(c))
			.findFirst()
			.orElse(' ');
		
		System.out.println("first common character: " + character);

	}

}
