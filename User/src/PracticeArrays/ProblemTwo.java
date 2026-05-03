package PracticeArrays;

public class ProblemTwo {

	public static void main(String args[]) {

		int a[] = { 1, 4, 45, 6, 10, 19 };
		int x = 51;

		int max = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {

				sum += a[j];

				if (sum > x) {
					result = Math.min(max, j - i + 1);
					break;
				}

			}
		}
		System.out.println(result);

	}
}
