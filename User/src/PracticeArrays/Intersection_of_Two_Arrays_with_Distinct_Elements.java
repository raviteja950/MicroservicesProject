package PracticeArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Intersection_of_Two_Arrays_with_Distinct_Elements {

	public static void main(String[] args) {

		int a[] = { 5, 6, 2, 1, 4 };
		int b[] = { 7, 9, 4, 2 };

		Arrays.sort(a);
		Arrays.sort(b);
		ArrayList<Integer> l = new ArrayList<>();
		// a=1,2,4,5,6
		// b=2,4,7,9

		HashSet<Integer> h = new HashSet<>();
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			h.add(a[i]);
		}

		for (int j = 0; j < b.length; j++) {

			if (h.contains(b[j])) {
				l.add(b[j]);
			} else {
				h.add(b[j]);
			}
		}
		System.out.println(l);

	}

}
