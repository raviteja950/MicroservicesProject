package PracticeArrays;

public class Sentence_Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Abc 012..##  10cbbA";
		String r = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(r);
		String[] a = r.split("");

		int left = 0;
		int right = r.length() - 1;

		while (left < right) {

			if (a[left].equals(a[right])) {
				System.out.println(true);
			}
			left++;
			right--;
		}

	}

}
