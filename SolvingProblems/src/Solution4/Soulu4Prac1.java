package Solution4;

import java.util.HashMap;
import java.util.Map;

public class Soulu4Prac1 {

	public int solution(String s) {

		String text = s;
		Map<Character, Integer> HM = new HashMap<>();

		for (char charText : text.toCharArray()) {
			HM.put(charText, HM.getOrDefault(charText, 0) + 1);
		}

		for (int i = 0; i < text.length(); i++) {
			if (HM.get(text.charAt(i)) == 1) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Soulu4Prac1 T = new Soulu4Prac1();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
