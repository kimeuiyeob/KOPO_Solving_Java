package Solution5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solu5Prac1 {

	public int[] solution(String s) {
		// HashMap 객체를 생성한다.
		Map<Character, Integer> HashM = new HashMap<>();
		// 문제가 5개의 값을 받는거라 배열에 5를 담는다.
		int[] answer = new int[5];
		// 파라미터로 받아온 문자열을 text에 담는다.
		String text = s;
		// text를 char배열로 만든다음에 반복돌린다 -> 문자하나하나 반복돌것이다.
		for (char key : text.toCharArray()) {
			// 각각의 문자를 키값으로 두고 밸류값을 누적시킨다.
			HashM.put(key, HashM.getOrDefault(key, 0) + 1);
		}
		// 최대값을 구하기 위해 max변수를 생성한다.
		// 그리고 HashM에 있는 값을 담는다. -> 어차피 밸류값을 다비교해서 가장큰값을 담을꺼다.
		int max = HashM.get(text.charAt(0));
		// 여기서 모든 밸류값을 가져와 가장높은 수를 max에 담는다.
		for (int i = 0; i < text.length(); i++) {
			if (max < HashM.get(text.charAt(i))) {
				max = HashM.get(text.charAt(i));
			}
		}
		// 문제가 a~e까지의 빈도수를 맞춰야하기 때문에 abcde문자열을 생성한다.
		String alphabet = "abcde";
		// 5번 반복돈다.
		for (int i = 0; i < alphabet.length(); i++) {
			// 첫번째 인덱스부터 값을 담는다.
			// 최대값에서 a부터 e까지의 밸류값을 가져온다음에 max에서 그 밸류값을 빼준 값을 배열에 담으면
			// 이게 빈도수를 맞추는거다.
			answer[i] = max - HashM.getOrDefault(alphabet.charAt(i), 0);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solu5Prac1 T = new Solu5Prac1();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
