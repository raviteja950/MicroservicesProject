package PracticeArrays;

public class Two_Sum_II {

	public static void main(String[] args) {
		int a[] = { -10, -8, -2, 1, 2, 5, 6 };
		int t = 0;

//		int l = 0;
//		int r = l + 1;
//
//		while (l < a.length - 1) {
//
//			if (r >= a.length) {
//				l++;
//				r = l + 1;
//				continue;
//			}
//
//			int sum = a[l] + a[r];
//			if (sum == t) {
//				System.out.println((l + 1) + " " + (r + 1));
//				break;
//			} else if (sum < t) {
//				r++;
//			} else {
//				l++;
//				r = l + 1;
//			}
//		}

		int l = 0;
		int r = a.length-1;

		while (l < r) {

			int sum = a[l] + a[r];

			if (sum == t) {
				System.out.println((l + 1) + " " + (r + 1));
				break;
			} else if (sum < t) {
				l++;
			} else {
				r--;
			}
		}

	}

}
