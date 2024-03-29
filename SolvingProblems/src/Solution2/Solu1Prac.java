package Solution2;

import java.util.Arrays;

public class Solu1Prac {

	public int[] solution(int[][] board, int k) {

		int[] answer = new int[2];
		int finalLine = board.length;

		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		int x = 0;
		int y = 0;

		int count = 0;
		int direction = 1;

		while (count < k) {
			count++;

			int NowX = x + directionX[direction];
			int NowY = y + directionY[direction];

			if (NowX < 0 || NowY < 0 || NowX >= finalLine || NowY >= finalLine || board[NowX][NowY] == 1) {
				direction = (direction + 1) % 4;
				continue;
			}
			x = NowX;
			y = NowY;
		}

		answer[0] = x;
		answer[1] = y;
		return answer;
	}
	

	public static void main(String[] args) {
		Solu1Prac T = new Solu1Prac();
		int[][] arr1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = { { 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}
}