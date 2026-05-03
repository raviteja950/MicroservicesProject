package PracticeArrays;

public class MoveZero {

	public static void main(String[] args) {

		int a[] = { 1, 0, 20, 4, 3, 0, 0, 5 };

		//move 0 to end
		int l = 0;
		int r = 0;
		while (r < a.length) {

			if (a[r] != 0) {
				int temp = a[r];
				a[r] = a[l];
				a[l] = temp;
				l++;
				r++;
			} else if (a[r] == 0) {
				r++;
			}
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
		//move zeros to starting	
//		int l = a.length-1;
//		int r = a.length-1;
//		while (r >=0) {
//
//			if (a[r] != 0) {
//				int temp = a[r];
//				a[r] = a[l];
//				a[l] = temp;
//				l--;
//				r--;
//			} else if (a[r] == 0) {
//				r--;
//			}
//		}
//		
//		for(int i=0;i<a.length;i++) {
//			System.out.print(a[i]+" ");
//		}
		
		
		

	}

}
