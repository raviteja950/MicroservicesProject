package Sorting;

public class MergeSort {

	static void merge(int a[], int l, int mid, int h) {

		int b[] = new int[a.length];
		int i = l;
		int j = mid + 1;
		int k = l;

		while (i <= mid && j <= h) {

			if (a[i] < a[j]) {
				b[k++] = a[i++];
				
			} else {
				b[k++] = a[j++];
			}
		}

		for (; i <= mid; i++) {
			b[k++] = a[i];
			
		}

		for (; j <= h; j++) {
			b[k++] = a[j];
			
		}

		for (i = l; i <= h; i++) {
			a[i] = b[i];
		}

	}

	static void mergeSort(int a[], int n) {

		int p, l, h, mid, i;

		for (p = 2; p <= n; p *= 2) {

			for (i = 0; i + p - 1 < n; i = i + p) {
				l = i;
				h = i + p - 1;
				mid = (l + h) / 2;
				merge(a, l, mid, h);
			}

			if (n - i > p / 2) {
				l = i;
				h = i + p - 1;
				mid = (l + h) / 2;
				merge(a, l, mid, n - 1);
			}
		}

		if (p / 2 < n) {
			merge(a, 0, (p / 2) - 1, n - 1);
		}
	}

	public static void main(String args[]) {
		int a[] = { 11, 7, 1, 6, 8, 4, 12, 13, 9 ,3, 2, 10, 5, 14};
		int n = a.length;
		int k = 9;
		mergeSort(a, n);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.print(a[k - 1]);

	}
}
