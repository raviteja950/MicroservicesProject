package PracticeArrays;

import java.util.Arrays;

public class Dominant_Pairs {

	public static void main(String[] args) {
		int a[] = { 10, 2, 2, 1 };
		int n = a.length;
		int count = 0;

//		for(int i=0;i<a.length/2;i++) {
//			
//			for(int j=a.length/2;j<a.length;j++) {
//				
//				if(a[i]>=5*a[j]) {
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
		Arrays.sort(a, 0, n / 2);
		Arrays.sort(a, n / 2, n);

		int i = 0;
		int j = a.length / 2;

		for (i = 0; i < a.length / 2; i++) {
			while (j < n && a[i] >= 5 * a[j]) {
				j++;
			}
			count += (j - a.length / 2);
		}
		System.out.println(count);
	}

}
