package org.abhishek.advenofcode2022.dayfive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingLineReader {
	
	private final String filePath;
	
	public ProcessingLineReader(String filePath) {
		this.filePath = filePath;
	}
	
	public static void main(String[] args) {
//		String processLine = "move 1 from 2 to 1";
//		ProcessingLineReader processingLineReader = new ProcessingLineReader(processLine);
//		processingLineReader.interpretProcessingLine();
//		System.out.println(processingLineReader.displayProcessingLine());
		
		ProcessingLineReader reader = new ProcessingLineReader("SampleInput.txt");
		List<String> allProcessingLines = reader.readProcessingLines();
		allProcessingLines.forEach(System.out::println);
	}
	
	public List<String> readProcessingLines() {
		FileReader reader = new FileReader(filePath);
		List<String> lines = reader.readLines();
		return lines.stream().filter(line -> line.startsWith("move")).collect(Collectors.toList());
	}
	
	public Instruction generateInstructionFromProcessingLine(String processingLine) {
		String[] split = processingLine.split(" ");
		List<String> list = Arrays.asList(split);
		//list.forEach(System.out::println);
		int numOfCratesToMove = Integer.parseInt(list.get(1));
		int sourceCrateStack = Integer.parseInt(list.get(3));
		int targetCrateStack = Integer.parseInt(list.get(5));
		Instruction instruction = new Instruction(numOfCratesToMove, sourceCrateStack, targetCrateStack);
		return instruction;
	}
}
