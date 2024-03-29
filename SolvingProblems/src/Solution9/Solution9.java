package Solution9;

import java.util.Arrays;

public class Solution9 {

	public int solution(int[] nums, int m) {

		// 몸무게 배열을 낮은순으로부터 정렬
		Arrays.sort(nums);
		int answer = 0;
		// 배열 처음 값
		int left = 0;
		// 배열 마지막 값
		int right = nums.length - 1;

		while (left <= right) {
			// 배열의 처음값과 마지막 값이 m보다 작거나 같으면 두명이서 배를 하나 탈수있다는 뜻이다.
			if (nums[left] + nums[right] <= m) {
				// 만약 true라면 배하나를 카운트한다.
				answer++;
				// left++은 다음 몸무게 계산을 위해 1씩 증감
				left++;
				// 마지막 배열에서 한칸 앞ㄹ으로...
				right--;
				// 만약 맨처음 배열과 마지막 배열의 합이 m보다 크다면
			} else {
				// 배를 하나 카운트해주고
				answer++;
				// 마지막 배열에서 한칸 앞으로... 마지막 사람 배에 태운것이다.
				right--;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution9 T = new Solution9();
		System.out.println(T.solution(new int[] { 90, 50, 70, 100, 60 }, 140));
		System.out.println(T.solution(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 100));
		System.out.println(T.solution(
				new int[] { 68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81 }, 120));
	}
}