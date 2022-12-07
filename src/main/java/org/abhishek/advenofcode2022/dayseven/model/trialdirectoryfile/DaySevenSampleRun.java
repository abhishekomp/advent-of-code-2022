package org.abhishek.advenofcode2022.dayseven.model.trialdirectoryfile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DaySevenSampleRun {

	public static void main(String[] args) {
		//Directory outerDir = createSingleDirectoryTree();
		Directory outerDir = createDirectoryTree();
		Stream<File> allFiles = outerDir.getAllFiles();
		allFiles.forEach(System.out::println);
	}

	private static Directory createSingleDirectoryTree() {
		// Single Directory with just files
		File file11 = new File(1100);
		File file12 = new File(1200);
		List<File> filesList = new ArrayList<File>();
		filesList.add(file11);
		filesList.add(file12);

		Directory singleDir = new Directory();
		singleDir.getFiles().addAll(filesList);
		return singleDir;
	}

	private static Directory createDirectoryTree() {
		// Inner Directory with 2 files and no directory
		File file11 = new File(1100);
		File file12 = new File(1200);
		List<File> innerDirFiles = new ArrayList<File>();
		innerDirFiles.add(file11);
		innerDirFiles.add(file12);

		Directory innerDir = new Directory();
		innerDir.getFiles().addAll(innerDirFiles);

		// Outer Directory contains inner Directory + 2 files
		File file1 = new File(100);
		File file2 = new File(200);
		List<File> outerDirFiles = new ArrayList<File>();
		outerDirFiles.add(file1);
		outerDirFiles.add(file2);

		Directory outerDir = new Directory();

		List<Directory> directories = new ArrayList<>();
		directories.add(innerDir);

		outerDir.getFiles().addAll(outerDirFiles);
		outerDir.getDirectories().addAll(directories);

		return outerDir;
	}

}
