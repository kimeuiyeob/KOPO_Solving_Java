package Solution9;

import java.util.Arrays;

public class Solu9Prac {

	public int solution(int[] nums, int m) {
		// 배열안의 값들을 작은수부터 큰수로 정렬한다.
		Arrays.sort(nums);

		int answer = 0;

		int[] humanWeight = nums;
		int limitWeight = m;

		int frotntArr = 0;
		int lastArr = nums.length - 1;

		// 아래 조건문은
		// 가장 작은 수랑 가장 큰수를 더해서 만약 그게 한계몸무게보다 작다면 2명을 태우고
		// 더 크다면 맨 큰수 1명은 배에 태우고
		// 인덱스 증감을 통해 2번째로 작은수와 2번째로 큰수 이런식으로 값비교해서 배틑 카운팅하는거다.
		while (frotntArr <= lastArr) {
			if (humanWeight[frotntArr] + humanWeight[lastArr] <= limitWeight) {
				answer++;
				frotntArr++;
				lastArr--;
			} else {
				answer++;
				lastArr--;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solu9Prac T = new Solu9Prac();
		System.out.println(T.solution(new int[] { 90, 50, 70, 100, 60 }, 140));
		System.out.println(T.solution(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 100));
		System.out.println(T.solution(
				new int[] { 68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81 }, 120));
	}
}