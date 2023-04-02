package Solution6;

import java.util.HashMap;
import java.util.HashSet;

public class Solution6 {

	public int solution(String s) {

		int count = 0;

		// HashMap �� HashSet�� ������
		// �켱 Map�� Ű�� ��������� ����ȴ� -> Ű�� �ߺ��Ұ� ����� �ߺ��㰡
		// Set�� ��ü ��ü�� �����ϱ� ������ �ߺ��Ұ�
		HashMap<Character, Integer> sH = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();

		// ���ڿ��� �Ѿ�� �Ķ���͸� ���ڷ� ���� �ݺ��� ������.
		for (char x : s.toCharArray()) {
			// �̶� sH�� Map�����̱⶧���� Ű�� ������� put���� ��´�.
			// ��ó�� Ű�� Ȯ���ؼ� ������ +1�����ְ� ������ ����������� +1�� �����Ѵ�.
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		System.out.println(sH);
//		entrySet()
//		Map�� entrySet() �Լ��� ����Ͽ� Map�� ��ü key�� value�� ������.
//		ketSet()
//		Map�� keySet() �Լ��� ����Ͽ� Map�� ��ü key�� ������.

		// �� Ű���� �� ������ �ϳ��ϳ��� �ݺ��� �����°Ŵ�.
		for (char key : sH.keySet()) {
			//
			while (ch.contains(sH.get(key))) {
				count++;
				sH.put(key, sH.get(key) - 1);
			}
			// ���� �ش�Ű�� ������� 0�̶�� continue
			if (sH.get(key) == 0) {
				continue;
			}
			// ch�� ��ü�� ����ȴ�.
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