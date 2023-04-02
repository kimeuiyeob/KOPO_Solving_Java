package Solution2;

import java.util.Arrays;

class Solution2 {
	public int[] solution(int[][] board, int k) {
		// 리턴해줄 배열 값
		int[] answer = new int[2];
		// 총 길이를 알기 위한 변수
		int finishLine = board.length;

		// 방향설정을 위한 배열
		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		// 현재 로봇 위치 설정
		int x = 0;
		int y = 0;

		// 반향설정
		int direction = 1;
		int count = 0;

		while (count < k) {
			count++;

			// 현재위치 + 갈방향을 더한 값을 담아준다.
			int nx = x + directionX[direction];
			int ny = y + directionY[direction];

			// 조건 : 로봇이 총길이랑 0을 넘어갈수 없고, 1을 만나면 안된다.
			if (nx < 0 || nx >= finishLine || ny < 0 || ny >= finishLine || board[nx][ny] == 1) {
				// 위의 조건문에 적합하면 방향전환뒤 continue
				direction = (direction + 1) % 4;
				continue;
			}

			// 조건문에 부합하지 않으면 잘가고있다는 뜻
			// 값을 담아준다.
			x = nx;
			y = ny;
		}

		// 마지막 값 리턴
		answer[0] = x;
		answer[1] = y;
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
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