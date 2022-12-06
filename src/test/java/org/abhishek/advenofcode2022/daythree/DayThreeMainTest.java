package org.abhishek.advenofcode2022.daythree;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DayThreeMainTest {
	
	DayThreeMain dayThreeMain = new DayThreeMain("SampleInput.txt");
	
	@Test
	void test_should_create_contents_of_each_compartment() {
		String line = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
		List<Compartment> compartments = dayThreeMain.createListCompartments(line);
		compartments.forEach(System.out::println);
	}
	
	@Test
	void test_should_return_fully_initialized_Rucksack_from_single_line() {
		String line = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
		Rucksack rucksack = dayThreeMain.createRucksack(line);
		System.out.println("Rucksack: " + rucksack);
		assertThat(rucksack.getCompartmentOne().getContent()).isEqualTo("jqHRNqRjqzjGDLGL");
		assertThat(rucksack.getCompartmentTwo().getContent()).isEqualTo("rsFMfFZSrLrFZsSL");
	}
	
	@Test
	void test_should_return_first_matching_character_from_Rucksack() {
		String line = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
		Character expectedCharacter = 'L';
		Rucksack rucksack = dayThreeMain.createRucksack(line);
		Character character = rucksack.findSingleCommonCharacterInCompartments();
		System.out.println("Rucksack: " + rucksack);
		System.out.println("Matching character: " + character);
		//assertThat(rucksack.getCompartmentOne().getContent()).isEqualTo("jqHRNqRjqzjGDLGL");
		//assertThat(rucksack.getCompartmentTwo().getContent()).isEqualTo("rsFMfFZSrLrFZsSL");
		assertThat(character).isEqualTo(expectedCharacter);
		Integer priority = AlphabetMap.getAlphaberMap().get(character);
		System.out.println("Priority of the character: " + priority);
	}
	
	

}
