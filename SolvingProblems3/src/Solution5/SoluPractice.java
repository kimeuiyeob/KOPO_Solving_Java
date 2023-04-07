package Solution5;

import java.util.Arrays;

public class SoluPractice {

	public int solution(int[] nums) {

		int answer = 0;
		// 이번 문제는 타이타닉 문제랑 상당히 흡사하다.
		// 보통 이러한 문제는 우선 배열을 먼저 정렬한다 오름차순으로
		// 그다음에 가장 첫인덱스랑 마지막 인덱스를 더한값이 5kg보다 작으면 값을 넣어주고 왼쪽은 인덱스를 하나 키우고 오른쪽은 인덱스를 줄인다.
		// 2개의 값이 들어갔기 때문이다.
		// 만약 오른쪽 무거운 값이 더해져서 들어가지지 않는다면 오른쪽꺼만 담고 오른쪽만 --를해주면서 계속 진행하면 된다.
		Arrays.sort(nums);

		// 왼쪽에서 오른쪽으로 갈 인덱스 숫자
		int left = 0;
		// 오른쪽에서 왼쪽으로 갈 인덱스 숫자 / nums.length - 1한 이유는 인덱스로 봐야하기 때문이다.
		int right = nums.length - 1;
		// 왼쪽 인덱스가 오른쪽 인덱스랑 같아지면 결국은 다돈거기때문에 조건을 이렇게 준다.
		while (left <= right) {
			// 가장 작은 무게 + 가장 무거운 무게가 5보다 작다면
			if (nums[left] + nums[right] <= 5) {
				// 한번 갓다온거기 때문에 갓다온 횟수 ++
				answer++;
				// 가장 작은무게를 담았기때문에 인덱스 오른쪽으로 한칸이동
				left++;
				// 가장 무거운 무게를 담았기때문에 인덱스 왼쪽으로 한칸이동
				right--;
				// else문은 가장 작은 무게 + 가장 무거운 무게가 5보다 컸을때이다.
				// 이럴때는 가장무거운거 하나만 담아준다.
			} else {
				// 그리고 가장 무거운거 한번 갓다왔기때문에 갓다온횟수 ++
				answer++;
				// 가장 무거운거 가서 왼쪽으로 인덱스 한칸 이동한다.
				right--;
			}
		}
		// 총 갓다온 횟수 누적해서 리턴값으로 반환한다.
		return answer;
	}

	public static void main(String[] args) {
		SoluPractice T = new SoluPractice();
		System.out.println(T.solution(new int[] { 2, 5, 3, 4, 2, 3 }));
		System.out.println(T.solution(new int[] { 2, 3, 4, 5 }));
		System.out.println(T.solution(new int[] { 3, 3, 3, 3, 3 }));
	}
}