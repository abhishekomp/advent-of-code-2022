package org.abhishek.advenofcode2022.dayfour;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import java.io.IOException;

public class DayFourMain {
	
	private final String filePath;
	
	public DayFourMain(String filePath) {
		this.filePath = filePath;
	}
	
	//Part 1 test method: test_should_check_assignments_contained_in_assignmentPair_for_inclusiveness
	//Part 2 test method: test_should_check_assignments_contained_in_assignmentPair_for_inclusiveness_Part2
	
	public List<String> readLines() {
		//Path path = FileSystems.getDefault().getPath("dayFour", "RealInput.txt");
		Path path = FileSystems.getDefault().getPath("puzzleInput/dayFour", filePath);
        //Path path = Path.of(filePath);
		
        try(Stream<String> lines = Files.lines(path);) {
            return lines.collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return Collections.EMPTY_LIST;
        //return Collections.<String>emptyList();
        return Collections.emptyList();
    }
	
	public Assignment createAssignment(String line) {
		//21-82 should create an assignment with start task as 21 and end task as 82
		String[] strings = line.split("-");
		Assignment assignment = new Assignment(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
		return assignment;
	}
	
	public Assignment createAssignmentFromArray(String[] strArr) {
		//21-82 should create an assignment with start task as 21 and end task as 82
		Assignment assignment = new Assignment(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
		return assignment;
	}
	
	public List<AssignmentPair> createAssignmentPair() {
		//Get each line from the file
		List<String> lines = readLines();
		
		//Create 2 assignment per line
		//Create the assignment pair
		//Store each assignment pair in a list of assignment pairs
		//Stream<String[]> map = lines.stream().map(line -> line.split(","));
		List<AssignmentPair> assignmentPairList = lines.stream()
			.map(this::createAssignmentsFromLine)
			.map(AssignmentPair::new)
			.collect(toList());	
		return assignmentPairList;
	}
	
	//from the complete single line this method creates 2 assignments and return the list of 2 assignments
	public List<Assignment> createAssignmentsFromLine(String line) {
		List<Assignment> assignmentsFromLine = Stream.of(line.split(","))
			.map(this::createAssignment)
			.collect(toList());
		return assignmentsFromLine;
	}
	
	@Deprecated
	public AssignmentPair createAssignmentPair(List<Assignment> assignmentList) {
		AssignmentPair assignmentPair = new AssignmentPair(assignmentList);
		return assignmentPair;
	}
	
	

}
