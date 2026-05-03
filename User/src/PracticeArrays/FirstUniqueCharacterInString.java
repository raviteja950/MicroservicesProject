package PracticeArrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		s.toCharArray();

//		Map<Character, Long> map = s.chars().mapToObj(e -> (char) e)
//				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//
//		System.out.println("Printing map : " + map);
//		List<Entry<Character, Long>> result = map.entrySet().stream().filter(e -> e.getValue() == 1)
//				.collect(Collectors.toList());
//
//		System.out.println("printing filter map with value 1: " + result);
//		Optional<Entry<Character, Long>> r = result.stream().findFirst();
//		System.out.println("Printing first value from filter  : " + r);
//
//		if (!result.isEmpty()) {
//			Character firstCharector = r.get().getKey();
//			System.out.println(firstCharector);
//			for (int i = 0; i < s.length(); i++) {
//
//				if (firstCharector.equals(s.charAt(i))) {
//					System.out.println(i);
//					break;
//				}
//			}
//
//		} else {
//			System.out.println("-1");
//		}

		// minimizing the code again
//		Character res= s.chars().mapToObj(e->(char)e)
//		         .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
//		         .entrySet()
//		         .stream()
//		         .filter(e ->e.getValue() == 1)
//		         .findFirst()
//		         .map(Map.Entry::getKey)
//		         .orElse(null);
//		
//		if(res!=null)
//		{
//			for(int i=0;i<s.length();i++) {
//				
//				if(res.equals(s.charAt(i)))
//				{
//					System.out.println(i);
//				}
//			}
//		}
//		else {
//			System.out.println(-1);
//		}

		// System.out.println(res);

		HashMap<Character, Integer> map = new HashMap<>();

		Queue<Character> queue = new LinkedList<Character>();

		for (int i = 0; i < s.length(); i++) {

			if (!map.containsKey(s.charAt(i))) {
				queue.add(s.charAt(i));
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
				queue.remove(s.charAt(i));
			}
		}
		
		//System.out.println(map);
		//System.out.println(queue);
		
		if(queue.isEmpty()) {
			System.out.println(-1);
		}
		else {
			for(int i=0;i<s.length();i++){
				if(queue.peek().equals(s.charAt(i))) {
					System.out.println(i);
				}
			}
		}
		//System.out.println(queue.peek());

	}

}
