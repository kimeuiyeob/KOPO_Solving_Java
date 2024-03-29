package Solution3;

public class Solu2Prac {

	public int solution(int[][] board) {

		// 인덱스 갯수 밖으로 넘어가면 안되기때문에 길이를 변수에 담는다.
		int finalLine = board.length;

		// 방향 설정
		int[] direcX = { -1, 0, 1, 0 };
		int[] direcY = { 0, 1, 0, -1 };

		// 사람과 개의 현재 위치 좌표
		int[] human = new int[2];
		int[] dog = new int[2];

		// 이차원 배열이기때문에 이중 반복문으로 사람과 개의 위치 찾기
		for (int i = 0; i < board.length; i++) {
			int[] boardArry = board[i];
			for (int j = 0; j < boardArry.length; j++) {
				if (board[i][j] == 2) {
					human[0] = i;
					human[1] = j;
				}
				if (board[i][j] == 3) {
					dog[0] = i;
					dog[1] = j;
				}
			}
		}
		// 사람,강아지 방향
		int directionForHuman = 0;
		int directionForDog = 0;
		int count = 0;

		while (count < 10000) {
			count++;
			// 현재위치 + 방향을 변수에 담는다.
			int x1 = human[0] + direcX[directionForHuman];
			int y1 = human[1] + direcY[directionForHuman];

			int x2 = dog[0] + direcX[directionForDog];
			int y2 = dog[1] + direcY[directionForDog];

			// 사람,강아지 플래그 두기
			boolean flag1 = true, flag2 = true;
			// 위치가 0보다 작거나 길이보다 크거나 1을 만나면 방향전환
			if (x1 < 0 || x1 >= finalLine || y1 < 0 || y1 >= finalLine || board[x1][y1] == 1) {
				directionForHuman = (directionForHuman + 1) % 4;
				// 이때 flag를 두어 아래 true문안에 값이 안담기게 막는다. 그리고 다시 반복돌때는 flag가 true로 초기화된다.
				flag1 = false;
			}
			if (x2 < 0 || x2 >= finalLine || y2 < 0 || y2 >= finalLine || board[x2][y2] == 1) {
				directionForDog = (directionForDog + 1) % 4;
				flag2 = false;
			}
			// 위 조건문에 부합되면 값이 안담기게 된다.
			if (flag1 == true) {
				human[0] = x1;
				human[1] = y1;
			}
			if (flag2 == true) {
				dog[0] = x2;
				dog[1] = y2;
			}
			// 사람,강아지 좌표가 같다면 같은 지점에서 만나게 된것이므로 break 반복문 탈출 -> 여태 카운트한 갯수 리턴
			if (human == dog)
				break;
		}
		if (count >= 10000)
			return 0;

		return count;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		int[][] arr1 = { { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 } };
		System.out.println(T.solution(arr1));
		int[][] arr2 = { { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 2, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 3 } };
		System.out.println(T.solution(arr2));
	}

}