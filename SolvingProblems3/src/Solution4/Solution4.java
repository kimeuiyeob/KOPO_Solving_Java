package Solution4;

import java.util.Arrays;
import java.util.HashMap;

public class Solution4 {

	public int[] solution(int[] nums) {

		// 넘어온 배열중 절반이 선생, 절반이 학생이므로 선생답만 담을꺼라 /2를 한다.
		int[] answer = new int[nums.length / 2];
		HashMap<Integer, Integer> nH = new HashMap<>();
		// 중복 제거 및 같은 숫자 밸류값 누적
		for (int x : nums)
			nH.put(x, nH.getOrDefault(x, 0) + 1);
		// 배열 오름차순으로 정렬 => 선생 숫자는 최소값이다.
		Arrays.sort(nums);
		// ++시켜줄 변수 생성
		int indexUp = 0;
		
		System.out.println("넘어온 배열 : " + Arrays.toString(nums));
		System.out.println("MAP : " + nH);
		
		for (int x : nums) {
			
			if (nH.get(x) == 0) {
				continue;
			}

			// 배열에 값을 담아준다.
			answer[indexUp] = x;
			indexUp++;

			// 그전에 nH에 누적된 숫자들을 여기서 빼준다.
			// 이렇게 되면 두개씩 빠지게된다.
			nH.put(x, nH.get(x) - 1);
			nH.put(x * 2, nH.get(x * 2) - 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
//		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[] { 1, 1, 6, 2, 2, 7, 3, 14 })));
//		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}