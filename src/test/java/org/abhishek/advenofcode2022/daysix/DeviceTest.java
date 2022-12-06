package org.abhishek.advenofcode2022.daysix;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class DeviceTest {
	
	
	@Test
	void should_test_Part1() {
		String dataStream = "bvwbjplbgvbhsrlpgdmjqwftvncz";
		Device device = new Device(dataStream);
		int startOfPacketMarker = device.findLenghtOfStartOfPacketMarket();
		assertThat(startOfPacketMarker).isEqualTo(5);
	}
	
	@Test
	void should_test_Part2() {
		String dataStream = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
		Device device = new Device(dataStream);
		int startOfPacketMarker = device.findLenghtOfStartOfPacketMarket();
		System.out.println(startOfPacketMarker);
		//assertThat(startOfPacketMarket).isEqualTo(5);
	}
	
	
	@Test
	void should_test_if_all_four_charcters_are_unique_Part1() {
		String dataStream = "abcd";
		Device device = new Device(dataStream);
		boolean isUnique = device.areAllCharactersUnique(dataStream);
		assertThat(isUnique).isTrue();
	}
	
	@Test
	void should_test_return_last_4_chars_from_string() {
		StringBuilder dataStream = new StringBuilder("abcdef");
		Device device = new Device(dataStream.toString());
		boolean isUnique = device.areLastFourCharsUnique(dataStream);
		assertThat(isUnique).isTrue();
	}
	
	@Test
	void should_test_detectFirstStartOfPacketMarker() {
		StringBuilder dataStream = new StringBuilder("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
		Device device = new Device(dataStream.toString());
		device.detectFirstStartOfPacketMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
	}
	
	@Test
	void should_test_if_all_four_charcters_are_unique() {
		String dataStream = "abcd";
		Device device = new Device(dataStream);
		Map<Integer, Long> map = device.areFourCharactersUnique(dataStream);
		map.forEach((k,v)-> System.out.println("key: " + k + " -> " + v));
		Map<Integer, Long> collect = map.entrySet()
		        .stream().filter(x->x.getValue() > 1)
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(collect.entrySet().size());
		//if this size is 0 then there are no repeating characters in the input string. (i.e. all characters are unique)	
	}

}
