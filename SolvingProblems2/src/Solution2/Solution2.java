package Solution2;

import java.util.ArrayList;

public class Solution2 {

	public int solution(int[] nums) {
		int answer = 0;
		int n = nums.length;
		ArrayList<Integer> peaks = new ArrayList<>();

		// 바이토닉 수열문제는 우선 꼭대기 지점을 찾아주는게 관건이다.
		// 꼭대기 지점이라는건 결국은 왼쪽이랑 오른쪽보다 가운데가 숫자가 크면된다.
		// 그래서 반복문을 통해서 찾아준다.
		for (int i = 1; i < n - 1; i++) {
			// 인덱스를 0부터 비교해야되니까 i를 1로주고 인덱스 길이로 계산하니까 n-1로 해준다.
			// 만약 인덱스 왼쪽보다 가운데가 더 크고 가운데가 오른쪽보다 크다면
			// 그 해당값을 peaks 리스트에다 담아준다. => 이렇게 되면 꼭대기 지점은 다 찾을수있다.
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peaks.add(i);
			}
		}
		// 꼭대기 지점 값들을 가져와 반복돌린다/
		// 여기서 포인트는 왼쪽이랑 오른쪽 나눠서 카운팅해주는거다.
		for (int x : peaks) {
			// 우선 해당 값을 왼쪽 오른쪽 변수에 담아주고
			int left = x;
			int right = x;
			int cnt = 1;
			// 왼쪽을 카운팅하는 반복문
			// 들어온 값을 다빼서 0보다 작아지면 안되고
			// 왼쪽 값보다 오른쪽 값이 더 크다면 카운팅을 증감하고 인덱스를 1씩 빼준다.
			// 이렇게 무한루프돌면 left가 0이될때까지랑 왼쪽 인덱스 값이 오른쪽 인덱스 값보다 크게되면 나가진다.
			while (left - 1 > 0 && nums[left - 1] < nums[left]) {
				left--;
				cnt++;
			}
			// 위랑 동일한 개념이지만 여기는 오른쪽 인덱스값을 왼쪽 인덱스 값이랑 비교해서 카운팅하는거다.
			while (right + 1 < n && nums[right] > nums[right + 1]) {
				right++;
				cnt++;
			}
			// 이때 Math.max함수를 사용하여 cnt가 가장 높은걸 answer로 담아서 리턴한다.
			System.out.println("최종 값 : " + cnt);
			answer = Math.max(answer, cnt);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[] { 1, 2, 1, 2, 3, 2, 1 }));
		System.out.println(T.solution(new int[] { 1, 1, 2, 3, 5, 7, 4, 3, 1, 2 }));
		System.out.println(T.solution(new int[] { 3, 2, 1, 3, 2, 4, 6, 7, 3, 1 }));
//		System.out.println(T.solution(new int[] { 1, 3, 1, 2, 1, 5, 3, 2, 1, 1 }));
	}
}