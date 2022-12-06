package org.abhishek.advenofcode2022.daythree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlphabetMap {
	
	public static Map<Character, Integer> getAlphaberMap() {
		List<Character> charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
				.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Map<Character, Integer> alphaberMap = new HashMap<>();
		for(int i = 0; i < charList.size(); i++) {
			alphaberMap.put(charList.get(i), (i+1));
		}
		//alphaberMap.forEach((key, value) -> System.out.println(key + ":" + value));
		return alphaberMap;
	}
}
