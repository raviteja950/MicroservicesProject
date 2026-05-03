package PracticeArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		int a[]= {10 ,23, 23, 27, 27, 32, 37, 48, 54, 66, 66, 90, 91, 91};
		
		LinkedHashSet<Integer> s= new LinkedHashSet<Integer>();
		ArrayList<Integer>l= new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			
			s.add(a[i]);
		}
		//System.out.println(s);
		for(Integer i:s) {
			l.add(i);
		}
		System.out.println(l);

	}

}
