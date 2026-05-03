package PracticeArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDuplicate {

	public static void main(String args[]) {

		int a[] = { 1, 2, 3, 4 };

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {

			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> r : map.entrySet()) {
			System.out.println(r.getKey() + " " + r.getValue());
			if (r.getValue() >= 2) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}

		System.out.println();

		Map<Integer, Long> StreamMap = Arrays.stream(a).mapToObj(e -> e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		boolean result = StreamMap.entrySet().stream().anyMatch(e -> e.getValue() >= 2);

		System.out.println(result);

	}
}
