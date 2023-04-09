package Solution1;

import java.util.Arrays;

public class SoluPracticeKim {
	public int[] solution(int c, int r, int k) {

		int[] answer = new int[2];
		int[][] seatArr = new int[c][r];

		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		int x = 0;
		int y = 0;
		int d = 1;
		int count = 1;
		int totalCount = c * r;

		while (count < k) {

			if (totalCount < k) {
				answer[0] = 0;
				answer[1] = 0;
				return answer;
			}

			int nx = x + directionX[d]; // 0
			int ny = y + directionY[d]; // 1

			if (nx < 0 || ny < 0 || nx >= c || ny >= r || seatArr[nx][ny] == 1) {
				d = (d + 1) % 4;
				continue;
			}

			count++;
			seatArr[x][y] = 1;

			x = nx;
			y = ny;

		}
		answer[0] = x + 1;
		answer[1] = y + 1;

		return answer;
	}

	public static void main(String[] args) {
		SoluPracticeKim T = new SoluPracticeKim();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}