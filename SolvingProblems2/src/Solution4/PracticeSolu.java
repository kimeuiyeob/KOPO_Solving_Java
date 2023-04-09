package Solution4;

import java.util.HashMap;
import java.util.Map;

public class PracticeSolu {
	public int solution(int[] nums, int m) {

		int answer = 0;
		int sum = 0;
		Map<Integer, Integer> HM = new HashMap<>();
		// 우선 HM에 0,1을 담아준다.
		HM.put(0, 1);
		// 이같은 문제는 누적을 시켜 값을 확인하는 방법이 쉽다.
		for (int i : nums) {
			// sum에다가 누적을 시킨다
			sum += i;
			// 우선적으로 containsKey()라는게 불린형태로 HM에 키값이 있다면 true아니면 false이다.
			// 처음에 2가 들어가면 지금 현재 상태에 HM은 키가0인 값밖에 없기때문에 조건문을 타지 않고 바로 HM에 키값 2를 담게된다.
			// HM.getOrDefault()을 사용하여 키값2가 또 들어올시 누적을 시켜준다.
			// 그다음 3번째 반복까지 오게 될 경우 누적값이 7이된다.
			// 7이되는경우 sum = 7 / m = 5이므로 7-5하면 2가 된다. HM에 키값이 2인게 있니?
			// 했을때 그전에 2가 담겼기 때문에 트루가 된다.
			// 그때 키의 발류값이 1이기때문에 answer에 1이 추가가된다. 이렇게 반복하면 답을 구할수있다.
			if (HM.containsKey(sum - m)) {
				answer += HM.get(sum - m);
			}
			HM.put(sum, HM.getOrDefault(sum, 0) + 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		PracticeSolu T = new PracticeSolu();
		System.out.println(T.solution(new int[] { 2, 2, 3, -1, -1, -1, 3, 1, 1 }, 5));
//		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2, 2, -3 }, 5));
//		System.out.println(T.solution(new int[] { 1, 2, 3, -3, 1, 2 }, 3));
//		System.out.println(T.solution(new int[] { -1, 0, 1 }, 0));
//		System.out.println(T.solution(new int[] { -1, -1, -1, 1 }, 0));
	}
}