package Solution6;

import java.util.HashMap;
import java.util.HashSet;

public class Solution6 {

	public int solution(String s) {

		int count = 0;

		// HashMap 과 HashSet의 차이점
		// 우선 Map은 키와 밸류값으로 저장된다 -> 키는 중복불가 밸류는 중복허가
		// Set은 객체 자체를 저장하기 때문에 중복불가
		HashMap<Character, Integer> sH = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();

		// 문자열로 넘어온 파라미터를 문자로 찢어 반복을 돌린다.
		for (char x : s.toCharArray()) {
			// 이때 sH는 Map구조이기때문에 키와 밸류값을 put으로 담는다.
			// 전처럼 키로 확인해서 없으면 +1을해주고 있으면 그전밸류값에 +1을 누적한다.
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		System.out.println(sH);
//		entrySet()
//		Map에 entrySet() 함수를 사용하여 Map의 전체 key와 value를 꺼낸다.
//		ketSet()
//		Map에 keySet() 함수를 사용하여 Map의 전체 key를 꺼낸다.

		// 즉 키들을 다 가져와 하나하나로 반복을 돌리는거다.
		for (char key : sH.keySet()) {
			//
			while (ch.contains(sH.get(key))) {
				count++;
				sH.put(key, sH.get(key) - 1);
			}
			// 만약 해당키의 밸류값이 0이라면 continue
			if (sH.get(key) == 0) {
				continue;
			}
			// ch는 객체가 저장된다.
			ch.add(sH.get(key));
		}
		return count;
	}

	public static void main(String[] args) {
		Solution6 T = new Solution6();
		System.out.println(T.solution("aaabbbcc"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}
}