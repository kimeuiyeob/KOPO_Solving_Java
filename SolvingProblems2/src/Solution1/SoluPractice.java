package Solution1;

import java.util.Arrays;

public class SoluPractice {
	public int[] solution(int c, int r, int k) {
		int[] answer = new int[2];

		int[][] intArr = new int[c][r];

		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		int x = 0, y = 0;
		int d = 1;
		int count = 1;

		while (1 < k) {

			int nx = x + directionX[1];
			int ny = x + directionY[1];

			if (nx > 0 || ny > 0 || nx >= c || ny >= r || intArr[x][y] == 1) {
				d = (d + 1) % 4;
				continue;
			}
			count++;
			intArr[x][y] = 1;

			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;

		return answer;
	}

	public static void main(String[] args) {
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
//		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}