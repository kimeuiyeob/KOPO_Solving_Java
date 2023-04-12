package 연습;

public class SnailPrac {
	public static void main(String[] args) {

		int number = 5;
		int[][] numberArr = new int[number][number];

		// 키포인트가 flag이다.
		int flag = 1;
		// 값이 들어가는 변수이다.
		int count = 1;
		int a = 0, b = -1;

		// 받아온 number가 반복이 한번될때마다 차감해서 0이되면 반복 탈출
		while (true) {
			// 우선 규칙을 찾아보면 처음에만 입력받은 숫자만큼 반복돌고 그뒤로부터는 44, 33, 22, 11이렇게 반복이 도는걸 확인할수있다.
			// 그래서 처음에 바로 5번 반복 돌고 아래 --로 반복 횟수를 줄여주었다.
			for (int i = 0; i < number; i++) {
				// flag가 1씩 b자리를 증감해서 값을 담아주었다.
				b += flag;
				numberArr[a][b] = count;
				count++;
			}
			// 맨위에 한번 반복돌면 가운데에다 꼭 --차감을 해줘야 그뒤로부터는 2번씩 같은 반복을 돌것이다.
			number--;
			for (int i = 0; i < number; i++) {
				// 규칙을 보면 행이 값이담기면 다음은 열이 값이 담겨야된다.
				// 그래서 b값은 그대로 유지시킨채 a값을 올려 2차원 배열구도로 보면
				// 값이 오른쪽으로 채워지면 아래로 채워진다.
				a += flag;
				numberArr[a][b] = count;
				count++;
			}
			// 여기가 포인트이다.
			// a와b가 값이 4,4로 꽉차있을거다. 이때 flag을 *연산을 통해서 -1로 만들면
			// 이제 위에 값이 채워진 경우 반대로 값이 들어갈거다. 오른쪽 아래로 값이 채워지면 이건 왼쪽 위로 값이 채워진다.
			flag *= -1;
			// 그리고 number--를 반복 2번돌때마다 차감해서 최종으로 반복 돌게 없다면 값이 다 채워졌다는걸 의미해서 탈출한다.
			if (number == 0) {
				break;
			}
		}
		//출력
		for (int[] numberarr : numberArr) {
			for (int numbers : numberarr) {
				System.out.print(numbers + "\t");
			}
			System.out.println();
		}

	}

}
