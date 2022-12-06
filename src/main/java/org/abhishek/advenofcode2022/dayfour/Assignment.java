package org.abhishek.advenofcode2022.dayfour;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment {

	private final int startTaskId;
	private final int endTaskId;

	public Assignment(int startTaskId, int endTaskId) {
		this.startTaskId = startTaskId;
		this.endTaskId = endTaskId;
	}
	
	public Assignment(String[] taskIndexArray) {
		this.startTaskId = Integer.parseInt(taskIndexArray[0]);
		this.endTaskId = Integer.parseInt(taskIndexArray[1]);;
	}

	public int getStartTaskId() {
		return startTaskId;
	}

	public int getEndTaskId() {
		return endTaskId;
	}
	
	List<Integer> assignmentAsListOfInteger() {
		int limit = endTaskId - startTaskId + 1;
        final List<Integer> integers = Stream.iterate(startTaskId, e -> e + 1)
                .limit(limit)
                .collect(Collectors.toList());
        return integers;
	}

	@Override
	public String toString() {
		return "Assignment [startTaskId=" + startTaskId + ", endTaskId=" + endTaskId + "]";
	}

}
