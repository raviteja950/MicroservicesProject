package PracticeArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Sort_Array_by_Increasing_Frequency {

	public static void main(String[] args) {

		int a[] = { 1, 1, 2, 2, 2, 3 };
		List<Integer> frequency = new ArrayList<>();

		int result[] = new int[a.length];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		System.out.println(map);

		Set<Integer> keys = map.keySet();

		for (int k : keys) {
			System.out.println(k + "->" + map.get(k));
			frequency.add(map.get(k));
		}

		System.out.println(frequency);
		Collections.sort(frequency);
		System.out.println(frequency);

	}

}
