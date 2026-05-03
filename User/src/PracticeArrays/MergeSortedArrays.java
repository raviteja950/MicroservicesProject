
package PracticeArrays;

import java.util.Arrays;

public class MergeSortedArrays {

	public static void main(String args[]) {
		int a[] = { 1, 2, 3 };
		int m = 3;
		int b[] = { 2, 5, 6 };
		int n = 3;

		int result[] = new int[m + n];
		int l = 0;
		int r = 0;
		int c = 0;
		while (l < a.length && r < b.length) {

			if (a[l] <= b[r]) {
				result[c] = a[l];
				l++;
				
			} else {
				result[c] = b[r];
				r++;
			}
			c++;
		}
		while (l < a.length) {
			result[c++] = a[l++];
		}
		while (r < b.length) {
			result[c++] = b[r++];
		}

		for (int i = 0; i < result.length; i++) {
			//a[i]=result[i];
			System.out.print(result[i]+" ");
		}

	}
}
