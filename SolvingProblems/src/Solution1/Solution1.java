package Solution1;

import java.util.Arrays;

class Solution1 {

	public char[] solution(int n, int[][] ladder) {

		char[] answer = new char[n];
		// 숫자를 알파벳으로 변경
		for (int i = 0; i < n; i++) {
			answer[i] = (char) (i + 65);
		}
		// 2차원 배열 반복 -> 배열갯수 반복
		for (int[] line : ladder) {
			// 배열안의 인덱스 갯수 반복
			for (int x : line) {
				// 저장해줄 변수 생성
				char tmp = answer[x];
				// 값 스왑
				answer[x] = answer[x - 1];
				answer[x - 1] = tmp;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(5, new int[][] { { 1, 3 }, { 2, 4 }, { 1, 4 } })));
		System.out.println(Arrays.toString(T.solution(7, new int[][] { { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
		System.out.println(
				Arrays.toString(T.solution(8, new int[][] { { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
		System.out.println(Arrays.toString(T.solution(12,
				new int[][] { { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));
	}

}