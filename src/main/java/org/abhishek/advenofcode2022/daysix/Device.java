package org.abhishek.advenofcode2022.daysix;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Device {
	
	private final String dataStream;

	public Device(String dataStream) {
		this.dataStream = dataStream;
	}
	
	public static void main(String[] args) {
		FileReader reader = new FileReader("RealInput.txt");
		List<String> readLines = reader.readLines();
		//Device device = new Device("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
		Device device = new Device(readLines.get(0));
		//device.detectFirstStartOfPacketMarker();
		System.out.println(device.findLenghtOfStartOfPacketMarket());
	}

	public String getDataStream() {
		return dataStream;
	}
	
	//Main invokable method for part 1
	public int findLenghtOfStartOfPacketMarket() {
		//return detectFirstStartOfPacketMarker(dataStream).length();
		return detectFirstStartOfPacketMarkerPart2(dataStream).length();
	}
	
	public String detectFirstStartOfPacketMarker(String source) {
		//Extract first 4 characters from the dataStream and store it in a temporary String.
		//Send this temporary stream to checker method areAllCharactersUnique to check if all 4 characters are unique
		//If the checker says yes then count how many characters do you have in your temporary String
		//If the checker says no then fetch next character from the dataStream and append to the temporary String
		//Then fetch last four characters from the temporary String and send again to the checker method
		
		StringBuilder sb = new StringBuilder(dataStream.substring(0, 1));
		//System.out.println(sb);
		
		StringBuilder orElseGet = dataStream.chars()
			.skip(1L)
			.mapToObj(c -> (char)c)
			.map(c -> this.append(sb, c))
			.filter(c -> c.length()>=4)
			.filter(this::areLastFourCharsUnique)
			.findFirst()
			.orElseGet(() -> new StringBuilder("NOK"));
		
//		System.out.println("sb:" + sb.toString());
//		System.out.println("orElse:" + orElseGet.toString());
		return orElseGet.toString();
	}
	
	public String detectFirstStartOfPacketMarkerPart2(String source) {
		//Extract first 4 characters from the dataStream and store it in a temporary String.
		//Send this temporary stream to checker method areAllCharactersUnique to check if all 4 characters are unique
		//If the checker says yes then count how many characters do you have in your temporary String
		//If the checker says no then fetch next character from the dataStream and append to the temporary String
		//Then fetch last four characters from the temporary String and send again to the checker method
		
		StringBuilder sb = new StringBuilder(dataStream.substring(0, 1));
		
		StringBuilder orElseGet = dataStream.chars()
			.skip(1L)
			.mapToObj(c -> (char)c)
			.map(c -> this.append(sb, c))
			.filter(c -> c.length()>=14)
			.filter(this::areLastFourteenCharsUnique)
			.findFirst()
			.orElseGet(() -> new StringBuilder("NOK"));
		
		return orElseGet.toString();
	}
	
	private StringBuilder append(StringBuilder sb, char c) {
		return sb.append(c);
		
	} 
	
	public boolean areLastFourCharsUnique(StringBuilder source) {
		String lastFourChars = source.substring(source.length()-4, source.length());
		//System.out.println(lastFourChars);
		return areAllCharactersUnique(lastFourChars);
	}
	
	public boolean areLastFourteenCharsUnique(StringBuilder source) {
		String lastFourChars = source.substring(source.length()-14, source.length());
		//System.out.println(lastFourChars);
		return areAllCharactersUnique(lastFourChars);
	}
	
	//Group by character and count the occurrence of each character in the String
	public boolean areAllCharactersUnique(String markerString) {
		//this will return the count of each character in the string in the form of a map
		Map<Integer, Long> charByCount = markerString.chars()
								.mapToObj(i->i)
								.collect(groupingBy(i->i, counting()));
		
		Map<Integer, Long> filteredCharByCount = charByCount.entrySet()
        	.stream().filter(x->x.getValue() > 1)
        	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return filteredCharByCount.entrySet().size() == 0;
		
	}
	
	//Make this a question for practice or a scenario in your java 8 scenarios
	@Deprecated
	public Map<Integer, Long> areFourCharactersUnique(String markerString) {
		//marker.chars().collect(groupingBy(i, counting()));
		//this will return the count of each character in the string in the form of a map
		Map<Integer, Long> collect = markerString.chars().mapToObj(i->i).collect(groupingBy(i->i, counting()));
		//System.out.println("collect map:" + collect);
		return collect;
	}

}
