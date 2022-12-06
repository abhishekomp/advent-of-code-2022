package org.abhishek.advenofcode2022.dayfour;

import java.util.List;
import java.util.function.Predicate;

public class AssignmentPair {
	
	private Assignment assignmentOne;
	private Assignment assignmentTwo;
	
	public AssignmentPair(Assignment assignmentOne, Assignment assignmentTwo) {
		this.assignmentOne = assignmentOne;
		this.assignmentTwo = assignmentTwo;
	}
	
	public AssignmentPair(List<Assignment> assignmentList) {
		this.assignmentOne = assignmentList.get(0);
		this.assignmentTwo = assignmentList.get(1);
	}
	
	//used in part 1 of the puzzle
	public boolean isAssignmentContainedWithinAnotherAssignment() {
		List<Integer> assignmentOneAsListOfInteger = assignmentOne.assignmentAsListOfInteger();
		List<Integer> assignmentTwoAsListOfInteger = assignmentTwo.assignmentAsListOfInteger();
		if(assignmentOneAsListOfInteger.containsAll(assignmentTwoAsListOfInteger) 
				|| assignmentTwoAsListOfInteger.containsAll(assignmentOneAsListOfInteger)) {
			return true;
		}
		return false;
	}
	
	//used in part 2 of the puzzle
	public boolean isAssignmentContainedWithinAnotherAssignmentPartTwo() {
		//List<Integer> assignmentOneAsListOfInteger = assignmentOne.assignmentAsListOfInteger();
		//List<Integer> assignmentTwoAsListOfInteger = assignmentTwo.assignmentAsListOfInteger();
		//assignmentOneAsListOfInteger.stream().anyMatch(e -> assignmentTwoAsListOfInteger.contains(e));
		Predicate<List<Integer>> predicateOne = assignmentOne -> assignmentOne
				.stream().anyMatch(e -> assignmentTwo.assignmentAsListOfInteger().contains(e));
		Predicate<List<Integer>> predicateTwo = assignmentTwo -> assignmentTwo
				.stream().anyMatch(e -> assignmentOne.assignmentAsListOfInteger().contains(e));
		if(predicateOne.test(assignmentOne.assignmentAsListOfInteger()) || predicateTwo.test(assignmentTwo.assignmentAsListOfInteger())) {
			return true;
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "AssignmentPair [assignmentOne=" + assignmentOne + ", assignmentTwo=" + assignmentTwo + "]";
	}
}
