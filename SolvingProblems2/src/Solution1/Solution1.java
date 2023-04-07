package Solution1;

import java.util.Arrays;

public class Solution1 {

	public int[] solution(int c, int r, int k) {

		// 값을 리턴해줄 anwer배열
		int[] answer = new int[2];
		// 2차원 배열을 오른쪽으로 한번 뒤집는게 포인트이다.
		int[][] intArr = new int[c][r];
		// 방향을 잡아줄 배열 생성
		int[] directionX = { -1, 0, 1, 0 };
		int[] directionY = { 0, 1, 0, -1 };

		int x = 0, y = 0, d = 1;
		int count = 1;
		// k로 해당 위치에 값을 찾는거라 while문에 k전까지 반복을 돌린다.
		while (count < k) {
			// 현재 방향
			int dx = x + directionX[d];
			int dy = y + directionY[d];
			// 방향이 배열 0보다 작거나 길이가 더 길거나 아니면 배열 값이 0보다 크면 조건문을 타게된다.
			if (dx < 0 || dy < 0 || dx >= c || dy >= r || intArr[dx][dy] > 0) {
				// 방향을 오른쪽으로 한칸 돌린다.
				d = (d + 1) % 4;
				// 이때는 방향전환이라 continue로 아래 값 안들어가게 막아준다.
				continue;
			}
			// 위에 if문에 타지 않았다면 한칸 전진했을테니 이때 count를 증감시켜준다.
			count++;
			// 위에 조건문에 intArr[dx][dy] > 0 이걸 해줬기때문에 한칸 증감하면 값을 채워준다. 다시 들어오지 못하게
			// 만약 이걸 안해주게 되면 가장자리면 뺑글뺑글 돌것이다.
			intArr[x][y] = 1;
			// 한칸 전진했다면 해당 x y 값을 담아준다.
			x = dx;
			y = dy;
		}

		// while문이 끝나면 요청 숫자만큼 돌았고 마지막 x y값을 담아준다. 예제에서는 1,1로 시작하는데
		// 배열은 0,0으로 시작하기 때문에 +1 을 해준거다.
		answer[0] = x + 1;
		answer[1] = y + 1;

		return answer;
	}

	public static void main(String[] args) {
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}