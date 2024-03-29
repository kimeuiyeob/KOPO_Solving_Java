package Solution7;

import java.util.HashSet;

public class Solution7 {
	public int solution(int[] nums) {

		int answer = 0;
		// HashSet 객체 생성
		HashSet<Integer> set = new HashSet<>();
		// 각각의 숫자를 x에 담아 반복한다.
		for (int x : nums) {
			// set에다가 각각의 숫자를 담는다.
			set.add(x);
		}

		// set에 담았기때문에 중복값은 다 사라졌다.
		// 중복값 사라진 set의 값을 하나씩 가져와 x에 담은다음에 반복한다.
		for (int x : set) {
			if (set.contains(x - 1)) {
				continue;
			}
			int cnt = 0;
			while (set.contains(x)) {
				cnt++;
				x++;
			}
			answer = Math.max(answer, cnt);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution7 T = new Solution7();
		System.out.println(T.solution(new int[] { 8, 1, 9, 3, 10, 2, 4, 0, 2, 3 }));
		System.out.println(T.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0 }));
		System.out.println(T.solution(new int[] { 3, 3, 3, 3, 3, 3, 3, 3 }));
		System.out.println(T.solution(new int[] { -3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1 }));
		System.out.println(T.solution(new int[] { -5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7 }));
	}
}