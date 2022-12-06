package org.abhishek.advenofcode2022.misc.creategroups;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderGroupCreator {
	
	private final String filePath;
	
	public FileReaderGroupCreator(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		FileReaderGroupCreator reader = new FileReaderGroupCreator("ExampleFile.txt");
		reader.createGroups();
	}
	
	public List<String> readLines() {
		Path path = FileSystems.getDefault().getPath("creategroups", filePath);
		// Path path = Path.of(filePath);
		try (Stream<String> lines = Files.lines(path);) {
			return lines.collect(toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public void createGroups() {
		List<String> lines = readLines();
		int startFrom = 0;
		List<ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
		while(startFrom < lines.size()) {
			List<String> groupOfThree = createGroupsOfThree(startFrom, lines);
			startFrom=startFrom+3;
			if(!groupOfThree.isEmpty()) {
				groups.add((ArrayList<String>) groupOfThree);
			}
		}
		groups.forEach(System.out::println);
	}
	
	public List<String> createGroupsOfThree(int startFrom, List<String> lines) {
		int maxIndex = lines.size() - 1;
		if(startFrom + 2 <= maxIndex) {
			String stringOne = lines.get(startFrom);
			String stringTwo = lines.get(startFrom + 1);
			String stringThree = lines.get(startFrom + 2);
			return new ArrayList<String>(Arrays.asList(stringOne, stringTwo, stringThree));
		}
		return Collections.emptyList();
	}

}
