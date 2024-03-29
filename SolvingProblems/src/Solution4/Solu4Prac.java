package Solution4;

import java.util.HashMap;
import java.util.Map;

class Solu4Prac {

	public int solution(String s) {

		// 알파벳을 만들 배열 생성
		char[] alphabet = new char[s.length()];

		// s문자열이 파라미터로 넘어오면 그 문자열의 길이만큼 반복한다.
		for (int i = 0; i < s.length(); i++) {
			// charAt으로 각각의 문자를 알파벳배열에 담는다.
			alphabet[i] = s.charAt(i);
		}

		// map은 순서및 중복 제거한다.
		Map<Character, Integer> hm = new HashMap<>();
		// Hashmap을 사용해 키와 밸류값으로 hm에 담아준다.
		// 알파벳을 순서대로 가져와 키(알파벳) 밸류(갯수) 이렇게 담는다.

		// 알파벳 배열을 가져와 문자의 갯수만큼 반복돈다. 이때 처음 key는 첫 문자로 반복도는것이다.
		for (Character key : alphabet) {
			// put은 map에서 값을 넣을때 사용
			// 키와 밸류값으로 넣어서 파라미터가 2개이다.
			// getOrDefault는 내장함수는 (key가 있니? 있으면 해당 밸류값 + 1) 없으면 0을 담아준다.
			// => 즉 처음에 key에 s가 들어오면 s는 이제 put으로 담기때문에 key는 s로 담아주고 getOrDefault에서 s가 키에 있니?
			// 없으니까 0인데
			// 뒤에 +1이 연산되어서 키s 의 밸류값은 1이 되는거다. 나중에 또 s가 들어요면 s있어 밸류는 1이야 거기다 +1을 해주면 s의 밸류값은
			// 2로 누적되는거다.
			hm.put(key, hm.getOrDefault(key, 0) + 1);
		}

		// 문제를 보면 인덱스의 위치를 찾아야한다.
		for (int i = 0; i < s.length(); i++) {
			// get으로 해당 키값을 가져오는데, s문자열의 각각의 문자를 가져와 그게 1이면 즉 중복이 없었다는것을 뜻하고
			if (hm.get(s.charAt(i)) == 1)
				// 해당 인덱스에 +1을 해줘서 순서를 알려주고 리턴한다.
				return i + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Solu4Prac T = new Solu4Prac();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}