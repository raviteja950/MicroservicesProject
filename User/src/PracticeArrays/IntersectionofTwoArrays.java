package PracticeArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionofTwoArrays {

	public static void main(String[] args) {

		int a[] = { 4,9,5 }, b[] = {9,4,9,8,4};

		Map<Integer, Long> map1 = Arrays.stream(a).mapToObj(e -> e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		HashSet<Integer> result= new HashSet<>();
		for (int i = 0; i < b.length; i++) {
            
			if(map1.containsKey(b[i])) {
				result.add(b[i]);
			}
			
		}
		int r[] =result.stream().mapToInt(e->e).toArray();
		
		for(int s:r) {
			System.out.println(s);
		}

	}

}
