package Solution6;

import java.util.Arrays;

public class Solution6 {
	public int solution(int n, int[] nums) {
		int answer = 0;

		int[][] line = new int[nums.length + 1][2];

		for (int i = 0; i <= n; i++) {
			line[i][0] = Math.max(0, i - nums[i]);
			System.out.println(i + "번째 Max : " + Math.max(0, i - nums[i]));
			line[i][1] = Math.min(n, i + nums[i]);
			System.out.println(i + "번째 Min : " + Math.min(n, i + nums[i]));
		}
		System.out.println();
		// Arrays.sort(T[], Comparator<? super T>)
		Arrays.sort(line, (a, b) -> a[0] - b[0]);
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(line[i][j] + " ");
			}
			System.out.println();
		}

		int start = 0, end = 0, i = 0;

		while (i < line.length) {
			while (i < line.length && line[i][0] <= start) {
				end = Math.max(end, line[i][1]);
				i++;
			}
			answer++;
			if (end == n)
				return answer;
			if (start == end)
				return -1;
			start = end;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution6 T = new Solution6();
		System.out.println(T.solution(8, new int[] { 1, 1, 1, 2, 1, 1, 2, 1, 1 }));
//		System.out.println(T.solution(4, new int[] { 1, 2, 2, 0, 0 }));
//		System.out.println(T.solution(5, new int[] { 2, 0, 0, 0, 0, 2 }));
//		System.out.println(T.solution(11, new int[] { 1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1 }));
	}
}