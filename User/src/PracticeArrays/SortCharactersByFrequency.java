package PracticeArrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tree";

		s.toCharArray();

		LinkedHashMap<Character, Long> map = s.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		
	LinkedHashMap<Character, Long>	newMap=map.entrySet().stream()
		.sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(e1,e2)-> e1 ,LinkedHashMap::new));
		
	System.out.println(newMap);
	
	List<Character> result= newMap.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
	  System.out.println(result);
	  
	  String fr=result.stream().map(String::valueOf).collect(Collectors.joining());
	  System.out.println(fr);
	}

}
