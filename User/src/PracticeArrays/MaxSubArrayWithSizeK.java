package PracticeArrays;

public class MaxSubArrayWithSizeK {

	public static void main(String[] args) {
		int a[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k = 4;

		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;

		while (j < a.length) {

			sum += a[j];

			if ((j - i + 1) < k) {
				j++;

			} else if ((j - i + 1) == k) {
				max = Math.max(max, sum);
				sum -= a[i];
				i++;
				j++;
			}

		}
		System.out.println(max);

	}

}
