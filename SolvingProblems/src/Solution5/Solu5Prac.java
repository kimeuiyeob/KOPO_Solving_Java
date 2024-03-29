package Solution5;

import java.util.Arrays;

//HashMap을 사용하지 않고 문제를 풀었다.
public class Solu5Prac {

	public int[] solution(String s) {
		// 우선 배열안의 크기가 5개인 배열을 생성한다.
		int[] answer = new int[5];
		// 파라미터로 넘어온 문자열을 text에 담는다.
		String text = s;
		// 문자열의 길이만큼한 char배열을 생성한다.
		char[] charArr = new char[text.length()];

		// charArr배열의 갯수가 즉 문자열의 길이만큼이기때문에 그만큼의 반복을 돈다.
		for (int i = 0; i < charArr.length; i++) {
			// 문자열을의 문자하나하나를 배열에 담는다.
			charArr[i] = text.charAt(i);
		}
		// 5칸짜리 알파벳 배열을 생성한다.
		int[] alphabet = new int[5];
		// 문자열에 소문자만 있어서 아스키코드를 사용하여 -97을 해주었다.
		// 이렇게 되면 a는 0이고 b는1 이런식이 된다.
		for (int i = 0; i < charArr.length; i++) {
			alphabet[(int) charArr[i] - 97] += 1;
		}
		// 최대값을 구하기 위해 배열안에 값을 일단 max에 담는다.
		int max = alphabet[0];
		// 하나하나 비교해서 가장 큰값이 max에 담기게된다.
		for (int i = 1; i < alphabet.length; i++) {
			if (alphabet[i] > max) {
				max = alphabet[i];
			}
		}
		// 총 5번의 반복을 돈다.
		for (int i = 0; i < alphabet.length; i++) {
			// 만약 배열안의 값이 최대값이랑 같다면 0이 들어가야 빈도수가 맞춰지기 때문에 0을 담는다.
			if (alphabet[i] == max) {
				answer[i] = 0;
				// 만약 max보다 작은 값이 담겨있다면 max에서 그해당 값을 뺀 값을 담으면 이렇게되면 빈도수가 맞춰진다.
			} else if (alphabet[i] < max) {
				answer[i] = max - alphabet[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solu5Prac T = new Solu5Prac();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
