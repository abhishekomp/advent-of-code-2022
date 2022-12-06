package org.abhishek.advenofcode2022.daythree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThreeMain {
	
	private final String filePath;
	
	public DayThreeMain(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		//DayThreeMain main = new DayThreeMain("SampleInput.txt");
		DayThreeMain main = new DayThreeMain("RealInput.txt");
		int sumOfPriorities = main.getSumOfPriorities();
		System.out.println("sumOfPriorities:" + sumOfPriorities);
	}
	
	public void createGroupOfThreeElf() {
		FileReader reader = new FileReader(filePath);
		List<String> lines = reader.readLines();
		
	}
	
	//Part 1
	public int getSumOfPriorities() {
		FileReader reader = new FileReader(filePath);
		List<String> lines = reader.readLines();
		int sum = lines.stream()
				.map(this::createRucksack)
				.map(this::findPriorityOfMatchingCharacterFromRucksack)
				.mapToInt(e -> e)
				.sum();
		System.out.println("Sum: " + sum);
		return sum;
	}
	
	public Integer findPriorityOfMatchingCharacterFromRucksack(Rucksack rucksack) {
		Character character = rucksack.findSingleCommonCharacterInCompartments();
		Integer priority = AlphabetMap.getAlphaberMap().get(character);
		return priority;
	}
	
	public Rucksack createRucksack(String line) {
		List<Compartment> compartments = createListCompartments(line);
		return new Rucksack(compartments);
	}
	
	public List<Compartment> createListCompartments(String line) {
		int length = line.length();
		String partOne = line.substring(0, length/2);
		String partTwo = line.substring(length/2);
		//System.out.println("PartOne: " + partOne + " partTwo: " + partTwo);
		Compartment compartmentOne = new Compartment(partOne);
		Compartment compartmentTwo = new Compartment(partTwo);
		
		List<Compartment> compartmentList = new ArrayList<>(Arrays.asList(compartmentOne, compartmentTwo));
		return compartmentList;
	}

}
