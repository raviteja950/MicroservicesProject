package PracticeArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "anagram", t = "nagaram";

		// HashMap<, Integer> map= new HashMap<Integer, Integer>();

		Map<Character, Long> sMap = s.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Character, Long> tMap = t.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		if (sMap.equals(tMap)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		
		
		int alpha[]= new int[26];
		for(int i=0;i<s.length();i++) {
			alpha[s.charAt(i)-'a']++;
			alpha[t.charAt(i)-'a']--;
		}
		
		for(int i=0;i<alpha.length;i++) {
			System.out.print(alpha[i]+ " ");
		}
		System.out.println();
		
		boolean result= !Arrays.stream(alpha).anyMatch(i -> i!=0);
		System.out.println(result);
	}

}
