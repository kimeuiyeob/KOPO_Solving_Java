package Solution5;

import java.util.Arrays;
import java.util.HashMap;

public class Solution5 {
	public int[] solution(String s) {
		// 우선 a~e까지의 알파벳으로 문제가 나와있기때문에
		// 5칸의 배열을 생성한다.
		int[] answer = new int[5];
		// HashMap을 생성한다. 키는 char 밸류는 int로 들어갈꺼기때문에 제네릭안에는 저렇게준다.
		HashMap<Character, Integer> sH = new HashMap<>();
		// 반복문을 돌린다 -> s파라미터로 넘어온 문자열을 toCharArry로 char형 배열로 만든다음 각각의 문자로 반복을 돌린다.
		for (char x : s.toCharArray()) {
			// 각각의 문자를 키값으로 주고 밸류값은 같은 문자가 또 온다면 누적시켜서 sh에 담는다.
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		// 최대값을 구하기 위해 변수 하나를 생성하고 값은 Integer클래스에서 가장작은 값을 담아놓는다.
		// 이 값보다는 max값이 클거기 때문이다.
		int max = Integer.MIN_VALUE;

		String tmp = "abcde";
		// abcde의 문자로 반복을 돌린다.
		for (char key : tmp.toCharArray()) {
			// 최대값을 구해야하기 때문에 각각의 키를 반복돌린다.
			// 밸류값이 max보다 크다면 그 밸류값을 max에 담는다.
			// 이렇게 전부 반복을 돌다보면 밸류값이 가장 높은게 max에 담기게된다.
			if (sH.getOrDefault(key, 0) > max) {
				max = sH.getOrDefault(key, 0);
			}
		}
		// a~e까지의 반복 즉 5번 반복을 돌린다.
		for (int i = 0; i < tmp.length(); i++) {
			// 배열 처음부터 각각 값을 담아준다.
			// a부터 밸류 값을 가져와 max에서 빼준값을 배열에 담는다. -> 이러면 같은 빈도수가 만들어진다.
			answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}