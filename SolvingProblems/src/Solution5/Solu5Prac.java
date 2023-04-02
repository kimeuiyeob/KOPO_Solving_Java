package Solution5;

import java.util.Arrays;

//HashMap�� ������� �ʰ� ������ Ǯ����.
public class Solu5Prac {

	public int[] solution(String s) {
		// �켱 �迭���� ũ�Ⱑ 5���� �迭�� �����Ѵ�.
		int[] answer = new int[5];
		// �Ķ���ͷ� �Ѿ�� ���ڿ��� text�� ��´�.
		String text = s;
		// ���ڿ��� ���̸�ŭ�� char�迭�� �����Ѵ�.
		char[] charArr = new char[text.length()];

		// charArr�迭�� ������ �� ���ڿ��� ���̸�ŭ�̱⶧���� �׸�ŭ�� �ݺ��� ����.
		for (int i = 0; i < charArr.length; i++) {
			// ���ڿ����� �����ϳ��ϳ��� �迭�� ��´�.
			charArr[i] = text.charAt(i);
		}
		// 5ĭ¥�� ���ĺ� �迭�� �����Ѵ�.
		int[] alphabet = new int[5];
		// ���ڿ��� �ҹ��ڸ� �־ �ƽ�Ű�ڵ带 ����Ͽ� -97�� ���־���.
		// �̷��� �Ǹ� a�� 0�̰� b��1 �̷����� �ȴ�.
		for (int i = 0; i < charArr.length; i++) {
			alphabet[(int) charArr[i] - 97] += 1;
		}
		// �ִ밪�� ���ϱ� ���� �迭�ȿ� ���� �ϴ� max�� ��´�.
		int max = alphabet[0];
		// �ϳ��ϳ� ���ؼ� ���� ū���� max�� ���Եȴ�.
		for (int i = 1; i < alphabet.length; i++) {
			if (alphabet[i] > max) {
				max = alphabet[i];
			}
		}
		// �� 5���� �ݺ��� ����.
		for (int i = 0; i < alphabet.length; i++) {
			// ���� �迭���� ���� �ִ밪�̶� ���ٸ� 0�� ���� �󵵼��� �������� ������ 0�� ��´�.
			if (alphabet[i] == max) {
				answer[i] = 0;
				// ���� max���� ���� ���� ����ִٸ� max���� ���ش� ���� �� ���� ������ �̷��ԵǸ� �󵵼��� ��������.
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