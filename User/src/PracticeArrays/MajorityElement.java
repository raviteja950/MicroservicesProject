package PracticeArrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

	public static void main(String[] args) {

		int nums[] = { 6,5,5 };

		Integer result = Arrays.stream(nums).mapToObj(e -> e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
				.entrySet().stream().map(Map.Entry::getKey).findFirst().get();

		Integer result1 = Arrays.stream(nums).mapToObj(e -> e)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > (nums.length / 2)).map(Map.Entry::getKey).findFirst().get();

		int majority = nums[0];
		int vote = 1;

		for (int i = 1; i <nums.length; i++) {

			if (vote == 0) {
				majority = nums[i];
				vote++;
			} else if (majority == nums[i]) {
				vote++;
			} else {
				vote--;
			}
		}

		System.out.println(result);
		System.out.println(result1);
		
		System.out.println(majority);
	}

}
