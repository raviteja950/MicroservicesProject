package PracticeArrays;

import java.util.Arrays;

public class pair_with_differnce_k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = { 8, 16, 12, 16, 4, 0 };
		int k = 4;

		// navie approch
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j <= a.length - 1; j++) {
				// System.out.println(a[i] + " " + a[j]);

				if ((a[i] - a[j]) == k || (a[j] - a[i]) == k) {
					// System.out.println(a[i] + "-" + a[j] + "==" + k);
					count++;
				}
			}
		}

		// Two pointer

		Arrays.sort(a);
		int i = 0;
		int j = 0;
		while (j < a.length) {

			if (a[j] - a[i] < k) {
				j++;
			} else if (a[j] - a[i] > k) {
				i++;
			} else if (a[j] - a[i] == k) {

				System.out.println(a[j] + " " + a[i]);
			}
		}

	}

}
