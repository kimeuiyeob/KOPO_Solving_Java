package Solution7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solu7Prac {
	public int solution(int[] nums) {
		// 중복값을 없애기 위해서 HashSet객체를 생성한다.
		HashSet<Integer> HS = new HashSet<>();
		// 파라미터로 넘어온 배열을 HS에 하나하나 담는다.
		for (int i = 0; i < nums.length; i++) {
			HS.add(nums[i]);
		}
		// HS갯수만큼의 배열하나 생성
		int[] numberArray = new int[HS.size()];
		// HashSet은 get으로 값을 꺼내오지 못해서 Iterator이라는 객체 생성뒤 hasnext()사용해서 값을 꺼내왔다.
		Iterator<Integer> iter = HS.iterator();
		int i = 0;
		while (iter.hasNext()) {
			// 값을 꺼내와서 다시 배열에 하나하나 담는다.
			numberArray[i] = iter.next();
			i++;
		}
		// 중복처리가 된 배열을 정렬시킨다.
		Arrays.sort(numberArray);
		// 최대값을 구하기 위해 변수 생성
		int max = 0;
		// 배열의 갯수만큼 반복 돌린다.
		for (int j = 0; j < numberArray.length; j++) {
			// 갯수를 세줄 변수 생성
			int counting = 0;
			// 1씩 값차이가 나는걸 확인하기 위해서 변수 생성
			int key = 1;
			// k변수에 j를 담고 반복을 돌린다.
			for (int k = j; k < numberArray.length; k++) {
				// +key를 해준 이유는 현재 값에서 +1을 한값이 동일하면 다음 인덱스값이랑 1차이난다는거다.
				if (numberArray[j] + key == numberArray[k]) {
					// true일때마다 count를 증감
					counting++;
					// 숫자가 계속 연결된게 아니라 끊어져 있어서
					// max라는 변수에 담아두고 카운트가 가장 많이 센걸 리턴한다.
					if (counting > max) {
						max = counting;
					}
					// 예를 들면 0인덱스에서 1,2,3,4이렇게 비교하기 위해서
					// key를 1씩 증감했다.
					key++;
				}
			}
		}
		// +1을 해준 이유는 조건문이 처음부터 하나하나세는게 아니라
		// 그뒤에값이랑 비교해서 세는거라 1이 부족하다. 그래서 결과값이 +1을 추가
		return max + 1;
	}

	public static void main(String[] args) {
		Solu7Prac T = new Solu7Prac();
		System.out.println(T.solution(new int[] { 8, 1, 9, 3, 10, 2, 4, 0, 2, 3 }));
		System.out.println(T.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0 }));
		System.out.println(T.solution(new int[] { 3, 3, 3, 3, 3, 3, 3, 3 }));
		System.out.println(T.solution(new int[] { -3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1 }));
		System.out.println(T.solution(new int[] { -5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7 }));
	}
}