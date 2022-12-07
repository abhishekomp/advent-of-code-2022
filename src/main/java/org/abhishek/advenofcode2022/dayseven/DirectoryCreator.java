package org.abhishek.advenofcode2022.dayseven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.abhishek.advenofcode2022.dayseven.model.Directory;
import org.abhishek.advenofcode2022.dayseven.model.File;
import org.abhishek.advenofcode2022.dayseven.model.LineStartMarker;

public class DirectoryCreator {

	private final String fileName;
	private final FileReader reader;
	
	private static final int TOTAL_SPACE = 70000000;
	private static final int MIN_UNUSED_SPACE = 30000000;

	public DirectoryCreator(String fileName) {
		this.fileName = fileName;
		this.reader = new FileReader(fileName);
	}

	public static void main(String[] args) {
		//DirectoryCreator dirCreator = new DirectoryCreator("SampleInput.txt");
		DirectoryCreator dirCreator = new DirectoryCreator("RealInput.txt");
		//dirCreator.findSumOfFileSizePartOne();
		//dirCreator.printSizeOfAllDir();
		dirCreator.directoriesThatCanBeDeletedToGetMinReqSpace();
	}

	public String getFileName() {
		return fileName;
	}
	
	public List<Directory> readFileAndCreateDirectoryStructure() {
		List<String> lines = reader.readLines();
		List<Directory> dirList = analyseLines(lines);		
		//System.out.println("All files for each directory(recursively)");
//		dirList.stream()
//		.filter(d -> d.getDirName().equals("a"))
//		.flatMap(Directory::getAllFiles)
//		.forEach(System.out::println);
		
//		dirList.stream()
//		.collect(Collectors.groupingBy(Directory::getDirName, summingInt(d -> d.getFiles().stream().map(File::getSize))));
		
//		dirList.stream()
//		.filter(d -> d.getDirName().equals("a"))
//		.flatMap(Directory::getAllFiles)
//		.forEach(System.out::println);
		return dirList;
	}
	
//	public int sizeOfDirectory(Directory dir) {
//		int sum = dir.getAllFiles().mapToInt(File::getSize).sum();
//		return sum;
//	}
	
	public void printSizeOfAllDir(List<Directory> dirList) {
		//List<Directory> dirList = readFileAndCreateDirectoryStructure();
		dirList.stream().forEach(d -> System.out.println(d.getDirName() + "-> " + d.getSize())); 
	}
	
	public int usedUpSpace(List<Directory> dirList) {
		//List<Directory> dirList = readFileAndCreateDirectoryStructure();
		int usedUpSpace = dirList.stream().filter(d -> d.getDirName().equals("root")).mapToInt(Directory::getSize).sum();
		return usedUpSpace;
	}
	
	public void directoriesThatCanBeDeletedToGetMinReqSpace() {
		List<Directory> directoryStructure = readFileAndCreateDirectoryStructure();
		int usedUpSpace = usedUpSpace(directoryStructure);
		int freeSpace = TOTAL_SPACE - usedUpSpace;
		List<Directory> dirThatCanBeDeleted = new ArrayList<>();
		//System.out.println("UsedUpSpace: " + usedUpSpace);
		for(Directory dir : directoryStructure) {
			if(freeSpace + dir.getSize() >= MIN_UNUSED_SPACE) {
				dirThatCanBeDeleted.add(dir);
			}
		}
		System.out.println("Directories that can be deleted: ");
		printSizeOfAllDir(dirThatCanBeDeleted);
		System.out.println("Smallest Directory that can be deleted has size: " + getSmallestDirectory(dirThatCanBeDeleted).getSize());
		//Directory smallestDirectory = getSmallestDirectory(dirThatCanBeDeleted);
	}

	private void findSumOfFileSizePartOne() {
		List<Directory> dirList = readFileAndCreateDirectoryStructure();
		//List<Directory> dirWithTotalSizePartOne = new ArrayList<>();
		int finalSumPartOne = 0;
		for(Directory dir : dirList) {
			List<File> fileList = dir.getAllFiles().collect(Collectors.toList());
			int sum = fileList.stream().mapToInt(File::getSize).sum();
			if(sum <= 100000) {
				finalSumPartOne = finalSumPartOne + sum;
			}
		}
		System.out.println("FinalSumPartOne: " + finalSumPartOne);
	}
	
	public Directory getSmallestDirectory(List<Directory> dirList) {
		Directory findFirst = dirList.stream().sorted(Comparator.comparingInt(Directory::getSize)).findFirst().orElse(null);
		return findFirst;
	}

	public void readFileAndCreateDirectoryStructure_Working() {
		List<String> lines = reader.readLines();
		List<Directory> dirList = analyseLines(lines);
		// dirList.forEach(System.out::println);
		for (Directory dir : dirList) {
			System.out.println(dir);
			System.out.println();
		}
		System.out.println("All files for dir a(without recursion)");
		dirList.stream()
			.filter(d -> d.getDirName().equals("a"))
			.map(Directory::getFiles)
			.forEach(System.out::println);
		
		System.out.println("All files for dir a(recursively)");
		dirList.stream()
		.filter(d -> d.getDirName().equals("a"))
		.flatMap(Directory::getAllFiles)
		.forEach(System.out::println);
	}

	private List<Directory> analyseLines(List<String> lines) {
		List<Directory> dirList = new ArrayList<>();
		Directory currDir = null;
		for (String line : lines) {
			//System.out.println("Processing line: " + line);
			LineStartMarker marker;
			if (line.startsWith("$ cd")) {
				marker = LineStartMarker.CD;
			} else if (line.startsWith("$ ls")) {
				marker = LineStartMarker.LS;
			} else {
				marker = LineStartMarker.OTHER;
			}
			// System.out.println(marker);
			// Initialize a directory if the line is cd is followed by anything but ..
			switch (marker.toString()) {
			case "CD":
				String cdEndsWith = line.substring(5);
				if (cdEndsWith.equals("/")) {
					Directory root = new Directory("root");
					dirList.add(root);
					currDir = root;
				} else if (cdEndsWith.equals("..")) {
					//System.out.println("Current Dir: " + currDir.getDirName() + " and Parent Dir: " + currDir.getParentDir().getDirName());
					currDir = currDir.getParentDir();
				} else if (Character.isLetterOrDigit(cdEndsWith.charAt(0))) {
					String[] split = line.split(" ");
					//Optional<Directory> findFirst = dirList.stream().filter(d -> d.getDirName().equals(split[2])).findFirst();
					Optional<Directory> findFirst = currDir.getDirectories().stream().filter(d -> d.getDirName().equals(split[2])).findFirst();
					//currDir = dirList.stream().filter(d -> d.getDirName().equals(split[2])).findFirst());
					currDir = findFirst.orElse(null);
				}
				break;
			case "OTHER":
				if (line.contains("dir")) {
					String dirName = line.substring(4);
					Directory directory = new Directory(dirName);
					currDir.getDirectories().add(directory);
					directory.setParentDir(currDir);
					dirList.add(directory);
				} else if (Character.isDigit(line.charAt(0))) {
					String[] split = line.split(" ");
					String fileName = split[1];
					int fileSize = Integer.parseInt(split[0]);
					File file = new File(fileName, fileSize);
					currDir.getFiles().add(file);
				}
				break;
			default:
				break;
			}

		}
		return dirList;
	}

}
