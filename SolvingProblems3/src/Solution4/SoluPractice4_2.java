package Solution4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SoluPractice4_2 {

	public int[] solution(int[] nums) {
		int[] answer = new int[nums.length / 2];

		Map<Integer, Integer> HM = new HashMap<>();
		for (int i : nums) {
			HM.put(i, HM.getOrDefault(i, 0) + 1);
		}
		Arrays.sort(nums);
		int count = 0;
		System.out.println(HM);

		for (int i : nums) {
			if (HM.get(i) == 0) {
				continue;
			}

			answer[count] = i;
			count++;

			// HM에 누적시켜놓은 밸류값을 여기서 차감
			// 선생값과 학생값을 뺀다.
			HM.put(i, HM.get(i) - 1);
			HM.put(i * 2, HM.get(i * 2) - 1);

		}

		return answer;
	}

	public static void main(String[] args) {
		SoluPractice4_2 T = new SoluPractice4_2();
//		System.out.println(Arrays.toString(T.solution(new int[] { 1, 10, 2, 3, 5, 6 })));
		System.out.println(Arrays.toString(T.solution(new int[] { 1, 1, 6, 2, 2, 7, 3, 14 })));
//		System.out.println(Arrays.toString(T.solution(new int[] { 14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14 })));
	}
}