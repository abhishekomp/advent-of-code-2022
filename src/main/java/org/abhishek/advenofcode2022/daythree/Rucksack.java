package org.abhishek.advenofcode2022.daythree;

import java.util.List;
import java.util.stream.Collectors;

public class Rucksack {
	
	private final Compartment compartmentOne;
	private final Compartment compartmentTwo;
	
	public Rucksack(Compartment compartmentOne, Compartment compartmentTwo) {
		this.compartmentOne = compartmentOne;
		this.compartmentTwo = compartmentTwo;
	}
	
	public Rucksack(List<Compartment> compartments) {
		this.compartmentOne = compartments.get(0);
		this.compartmentTwo = compartments.get(1);
	}

	public Compartment getCompartmentOne() {
		return compartmentOne;
	}

	public Compartment getCompartmentTwo() {
		return compartmentTwo;
	}
	
	public Character findSingleCommonCharacterInCompartments() {
		List<Character> compartmentOneCharList = compartmentOne.getContent()
					.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		List<Character> compartmentTwoCharList = compartmentTwo.getContent()
				.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		Character character = compartmentOneCharList.stream()
				.sorted()
				.filter(c -> compartmentTwoCharList.contains(c))
				.findFirst()
				.orElse(' ');
		return character;
	}

	@Override
	public String toString() {
		return "Rucksack [compartmentOne=" + compartmentOne + ", compartmentTwo=" + compartmentTwo + "]";
	}

	
}
