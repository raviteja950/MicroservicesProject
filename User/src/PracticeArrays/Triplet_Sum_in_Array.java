package PracticeArrays;

import java.util.Arrays;

public class Triplet_Sum_in_Array {

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 3, 6, 7 };
		int t = 10;
		int count = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length - 2; i++) {

			int l = i + 1;
			int r = a.length - 1;
			while (l < r) {

				int rs = t - a[i];
				if (a[l] + a[r] == rs) {
					System.out.println(a[i] + " " + a[l] + " " + a[r]);
					count++;
					l++;
					r--;

				} else if (a[l] + a[r] < rs) {
					l++;
				} else {
					r--;
				}
			}
		}
		System.out.println(count);

	}

}
