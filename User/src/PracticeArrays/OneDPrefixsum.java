package PracticeArrays;

import java.util.ArrayList;

public class OneDPrefixsum {

	public static void main(String[] args) {
		int a[] = { 30, 10, 10, 5, 50 };

		int ps[] = new int[a.length];

		ArrayList<Integer> list = new ArrayList<>();
		ps[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			ps[i] = ps[i - 1] + a[i];
		}

		for (int i : ps) {
			list.add(i);
		}
		
		System.out.println(list);

	}

}
