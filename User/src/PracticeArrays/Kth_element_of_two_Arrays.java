package PracticeArrays;

import java.util.Arrays;

public class Kth_element_of_two_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 4, 8, 10, 12 };
		int b[] = { 5, 7, 11, 15, 17 };
		int k = 6;

		int ab[] = new int[a.length + b.length];

		int count = 0;
		for (int i = 0; i < a.length; i++) {
			ab[i] = a[i];
			count++;
		}
		// System.out.println(count);

		for (int j = 0; j < b.length; j++) {
			ab[count] = b[j];
			count++;
		}

		Arrays.sort(ab);
		System.out.println(ab[k - 1]);

	}

}
