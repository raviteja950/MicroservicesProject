package PracticeArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problemOne {

	public static void main(String[] args) {
		// arr[] = [10, 30, 20, 5], target = 25

		int a[] = { 5, 2, 7, 1, 4 };
		int t = 10;
		ArrayList<Integer> res = new ArrayList<>();
		int md = Integer.MAX_VALUE;
		Arrays.sort(a);

		int l = 0;
		int r = a.length - 1;
		while (l < r) {
			int csum = a[l] + a[r];
			int cd = Math.abs(t - csum);

			if (cd < md) {
				md = cd;
				res = new ArrayList<>(Arrays.asList(a[l], a[r]));
			} else if (csum == t) {
				res = new ArrayList<>(Arrays.asList(a[l], a[r]));
			} else if (csum < t) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println(res);

	}

}
