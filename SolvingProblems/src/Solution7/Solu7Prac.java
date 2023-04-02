package Solution7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solu7Prac {
	public int solution(int[] nums) {
		// �ߺ����� ���ֱ� ���ؼ� HashSet��ü�� �����Ѵ�.
		HashSet<Integer> HS = new HashSet<>();
		// �Ķ���ͷ� �Ѿ�� �迭�� HS�� �ϳ��ϳ� ��´�.
		for (int i = 0; i < nums.length; i++) {
			HS.add(nums[i]);
		}
		// HS������ŭ�� �迭�ϳ� ����
		int[] numberArray = new int[HS.size()];
		// HashSet�� get���� ���� �������� ���ؼ� Iterator�̶�� ��ü ������ hasnext()����ؼ� ���� �����Դ�.
		Iterator<Integer> iter = HS.iterator();
		int i = 0;
		while (iter.hasNext()) {
			// ���� �����ͼ� �ٽ� �迭�� �ϳ��ϳ� ��´�.
			numberArray[i] = iter.next();
			i++;
		}
		// �ߺ�ó���� �� �迭�� ���Ľ�Ų��.
		Arrays.sort(numberArray);
		// �ִ밪�� ���ϱ� ���� ���� ����
		int max = 0;
		// �迭�� ������ŭ �ݺ� ������.
		for (int j = 0; j < numberArray.length; j++) {
			// ������ ���� ���� ����
			int counting = 0;
			// 1�� �����̰� ���°� Ȯ���ϱ� ���ؼ� ���� ����
			int key = 1;
			// k������ j�� ��� �ݺ��� ������.
			for (int k = j; k < numberArray.length; k++) {
				// +key�� ���� ������ ���� ������ +1�� �Ѱ��� �����ϸ� ���� �ε������̶� 1���̳��ٴ°Ŵ�.
				if (numberArray[j] + key == numberArray[k]) {
					// true�϶����� count�� ����
					counting++;
					// ���ڰ� ��� ����Ȱ� �ƴ϶� ������ �־
					// max��� ������ ��Ƶΰ� ī��Ʈ�� ���� ���� ���� �����Ѵ�.
					if (counting > max) {
						max = counting;
					}
					// ���� ��� 0�ε������� 1,2,3,4�̷��� ���ϱ� ���ؼ�
					// key�� 1�� �����ߴ�.
					key++;
				}
			}
		}
		// +1�� ���� ������ ���ǹ��� ó������ �ϳ��ϳ����°� �ƴ϶�
		// �׵ڿ����̶� ���ؼ� ���°Ŷ� 1�� �����ϴ�. �׷��� ������� +1�� �߰�
		return max + 1;
	}

	public static void main(String[] args) {
		Solu7Prac T = new Solu7Prac();
		System.out.println(T.solution(new int[] { 8, 1, 9, 3, 10, 2, 4, 0, 2, 3 }));
		System.out.println(T.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0 }));
		System.out.println(T.solution(new int[] { 3, 3, 3, 3, 3, 3, 3, 3 }));
		System.out.println(T.solution(new int[] { -3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1 }));
		System.out.println(T.solution(new int[] { -5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7 }));
	}
}