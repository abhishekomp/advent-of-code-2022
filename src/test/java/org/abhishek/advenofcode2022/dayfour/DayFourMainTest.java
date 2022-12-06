package org.abhishek.advenofcode2022.dayfour;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DayFourMainTest {
	
	DayFourMain reader = new DayFourMain("RealInput.txt");
	
	@Test
	void test_should_read_file_and_return_list() {
		List<String> lines = reader.readLines();
		lines.forEach(System.out::println);
		assertThat(lines).hasSize(2);
	}
	
	@Test
	void test_should_return_a_fully_initialized_assignment() {
		String line = "22-41";
		Assignment assignment = reader.createAssignment(line);
		System.out.println("Created Assignment: " + assignment);
		assertThat(assignment.getStartTaskId()).isEqualTo(22);
		assertThat(assignment.getEndTaskId()).isEqualTo(41);
	}
	
	@Test
	void test_should_return_a_fully_initialized_assignment_from_String_array() {
		String[] assignmentTaskArray = {"22", "41"};
		Assignment assignment = reader.createAssignmentFromArray(assignmentTaskArray);
		System.out.println("Created Assignment: " + assignment);
		assertThat(assignment.getStartTaskId()).isEqualTo(22);
		assertThat(assignment.getEndTaskId()).isEqualTo(41);
	}
	
	@Test
	void test_should_return_a_list_of_Assignments_with_Two_Assignments() {
		String line = "21-82,22-81";
		List<Assignment> assignments = reader.createAssignmentsFromLine(line);
		System.out.println("Created Assignment: ");
		assignments.forEach(System.out::println);
		assertThat(assignments).hasSize(2);
	}
	
	@Test
	void test_should_an_assignmentPair_with_two_assignments() {
		List<AssignmentPair> list = reader.createAssignmentPair();
		System.out.println("Created AssignmentPairs: ");
		list.forEach(System.out::println);
		assertThat(list).hasSize(2);
	}
	
	//Solution of Part 1
	@Test
	void test_should_check_assignments_contained_in_assignmentPair_for_inclusiveness() {
		List<AssignmentPair> list = reader.createAssignmentPair();
		System.out.println("Count of AssignmentPairs: " + list.size());
		int countOfInclusion = 0;
		//list.forEach(System.out::println);
		for(int i = 0; i < list.size(); i++) {
			boolean isIncluded = list.get(i).isAssignmentContainedWithinAnotherAssignment();
			//System.out.println(isIncluded);
			if(isIncluded) {
				countOfInclusion++;
			}
			
		}
		System.out.println("Final inclusion count: " + countOfInclusion);
	}
	
	//Solution of Part 2
	@Test
	void test_should_check_assignments_contained_in_assignmentPair_for_inclusiveness_Part2() {
		List<AssignmentPair> list = reader.createAssignmentPair();
		System.out.println("Count of AssignmentPairs: " + list.size());
		int countOfInclusion = 0;
		//list.forEach(System.out::println);
		for(int i = 0; i < list.size(); i++) {
			boolean isIncluded = list.get(i).isAssignmentContainedWithinAnotherAssignmentPartTwo();
			//System.out.println(isIncluded);
			if(isIncluded) {
				countOfInclusion++;
			}
			
		}
		System.out.println("Final inclusion count: " + countOfInclusion);
	}

}
