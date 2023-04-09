package Solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoluPractice4_1 {
	public int[] solution(int[] nums) {
		
		List<Integer> teacher = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (String.valueOf((nums[i] + nums[i])).equals(String.valueOf(nums[j]))) {
					teacher.add(nums[i]);
					break;
				}
			}
		}
		int[] answer = new int[teacher.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = teacher.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {

		SoluPractice4_1 T = new SoluPractice4_1();
		System.out.println(Arrays.toString(T.solution(new int[] { 1, 10, 2, 3, 5, 6 })));
//		System.out.println(Arrays.toString(T.solution(new int[] { 1, 1, 6, 2, 2, 7, 3, 14 })));
//		System.out.println(Arrays.toString(T.solution(new int[] { 14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14 })));
	}
}