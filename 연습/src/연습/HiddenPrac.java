package ¿¬½À;

import java.util.Arrays;

public class HiddenPrac {

	public String[] solution(int n, int[] arr1, int[] arr2) {

		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
			answer[i] = String.format("%" + n + "s", answer[i]).replace(" ", "0");
			answer[i] = answer[i].replaceAll("1", "#").replaceAll("0", " ");
		}
		return answer;
	}

	public static void main(String[] args) {
		HiddenMap hm = new HiddenMap();
		String[] answer1 = hm.solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 });
		System.out.println(Arrays.toString(answer1));
		String[] answer2 = hm.solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 });
		System.out.println(Arrays.toString(answer2));
	}
}