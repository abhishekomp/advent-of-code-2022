package org.abhishek.advenofcode2022.dayseven;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

	private final String filePath;

	public FileReader(String filePath) {
		this.filePath = filePath;
	}

	public List<String> readLines() {
		// Path path = FileSystems.getDefault().getPath("dayFour", "RealInput.txt");
		Path path = FileSystems.getDefault().getPath("puzzleInput/dayseven", filePath);
		// Path path = Path.of(filePath);

		try (Stream<String> lines = Files.lines(path);) {
			return lines.collect(toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// return Collections.EMPTY_LIST;
		// return Collections.<String>emptyList();
		return Collections.emptyList();
	}

}
