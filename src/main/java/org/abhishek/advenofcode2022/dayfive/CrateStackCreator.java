package org.abhishek.advenofcode2022.dayfive;

import java.util.Arrays;
import java.util.List;

public class CrateStackCreator {
	
	public static void main(String[] args) {
		CrateStackCreator creator = new CrateStackCreator();
		creator.createStackFromLine("1 [Z] [N]");
		//creator.createStackFromLine("2 [M] [C] [D]");
		//creator.createStackFromLine("3 [P]");
	}

	public CratesStack createStack(int StackId, char[] charArray) {

		CratesStack crateStack = new CratesStack(StackId, charArray);
		return crateStack;
	}
	
	public CratesStack createStackFromLine(String line) {
		char[] characters = createArrayForCrateStack(line);
//		for(int i = 0; i < characters.length; i++) {
//			System.out.println(characters[i]);
//		}
		
		//int stackId = line.charAt(0) - '0';
		
		CratesStack crateStack = new CratesStack(line.charAt(0) - '0', characters);
		return crateStack;
	}
	
	public char[] createArrayForCrateStack(String line) {
		String[] strings = line.split(" ");
		List<String> asList = Arrays.asList(strings);
		List<String> subList = asList.subList(1, asList.size());
		//String[] stringArray = stringStream.toArray(String[]::new);
		char[] charArray = new char[subList.size()];
		for(int i = 0; i < subList.size(); i++) {
			charArray[i] = subList.get(i).charAt(1);
		}
		//Character[] charArray = subList.stream().toArray(Character[]::new);
		return charArray;
	}

//	private void populateStack(CratesStack stack, char[] array) {
//		for(int i = 0; i < array.length; i++) {
//			stack.addCrate(array[i]);
//		}
//		
//	}

}
