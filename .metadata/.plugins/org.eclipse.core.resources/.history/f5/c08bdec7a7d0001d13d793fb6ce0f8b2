package Solution4;

import java.util.HashMap;

public class Solution4 {

	public int solution(String s) {
		// HashMap 생성
		// 제네릭은 키는 char 밸류는 int이기때문에 저렇게 받는다.
		HashMap<Character, Integer> sH = new HashMap<>();

		// s문자열이 넘어오면 char배열로 만든뒤 x에 한문자씩 넣어서 반복을 돌린다.
		for (char x : s.toCharArray()) {
			// sh에 키(알파벳) 밸루(갯수) 가 누적된다.
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		// 문자열 길이만큼 반복
		for (int i = 0; i < s.length(); i++) {
			// 여기서 sh.get은 키값으로 찾아오는건데
			// 그전에 sh에 중복은제고 각각의 알파벳을 담아뒀다.
			// 여기서 그 알파벳을 가져오는데 s문자열의 알파벳이랑 같을때 그 문자의 밸류값이 1이면 즉 누적된거 하나라 중복이 없었다는거다.
			if (sH.get(s.charAt(i)) == 1)
				// 여기서 i는 즉 인덱스숫자와 같기때문에 그인덱스에 +1을 해준것이다.
				// +1을 해준이유는 문제보면 0부터 시작하지 않기때문이다.
				return i + 1;
		}
		// 여기로 왔다는거는 모든 문자가 중복되었다는 뜻이라 -1을 리턴해준다.
		return -1;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
