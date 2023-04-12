package 연습;

import java.util.Arrays;

public class HiddenMap {

	public String[] solution(int number, int[] array1, int[] array2) {

//		======================================================
		// 첫번째 array1 값 이진법으로 바꾼후 값 담기
		String[][] twoArrString1 = new String[number][number];
		String[] toString1 = new String[number];
		// 두번째 array2 값 이진법으로 바꾼후 값 담기
		String[][] twoArrString2 = new String[number][number];
		String[] toString2 = new String[number];

		String Zero = "0";
		String One = "1";

//		======================================================
		// 받아온 숫자를 이진법으로 교환 , 하지만 앞에 0이 있으면 사라지기 때문에 조건문
		// 만들어서 글자가 부족하면 부족한만큼 앞에 0을 붙임
		for (int i = 0; i < number; i++) {
			String toBinary1 = Integer.toBinaryString(array1[i]);
			String toBinary2 = Integer.toBinaryString(array2[i]);
			int addZero1 = number - toBinary1.length();
			int addZero2 = number - toBinary2.length();
			if (toBinary1.length() < number) {
				for (int j = 0; j < addZero1; j++) {
					toBinary1 = Zero.concat(toBinary1);
				}
			}
			if (toBinary2.length() < number) {
				for (int j = 0; j < addZero2; j++) {
					toBinary2 = Zero.concat(toBinary2);
				}
			}
			toString1[i] = toBinary1;
			toString2[i] = toBinary2;
		}
//		======================================================
		// 1차원 배열에 있던 이진법 숫자를 찢어 2차원 배열로 만든다.
		for (int i = 0; i < toString1.length; i++) {
			String tmp1 = toString1[i];
			String tmp2 = toString2[i];
			for (int j = 0; j < tmp1.length(); j++) {
				twoArrString1[i][j] = String.valueOf(tmp1.charAt(j));
				twoArrString2[i][j] = String.valueOf(tmp2.charAt(j));
			}
		}

//		======================================================
		// 두개의 2차원 배열 합치기 -> 1일때는 넘어가고 0일때만 두번재 배열에 1이있는지 확인후
		// 1이 있으면 1담고 없으면 그대로 0으로 보내준다.
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				if (twoArrString1[i][j].equals(Zero)) {
					if (twoArrString2[i][j].equals(Zero)) {
						continue;
					} else if (twoArrString2[i][j].equals(One)) {
						twoArrString1[i][j] = One;
					}
				}
			}
		}

//		======================================================
		// 1과 0으로 합쳐진 2차원배열을 1일때는 #바꾸고 0일때는 " "바꾸기
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				if (twoArrString1[i][j].equals(One)) {
					twoArrString1[i][j] = "#";
				} else if (twoArrString1[i][j].equals(Zero)) {
					twoArrString1[i][j] = " ";
				}
			}
		}

//		======================================================
		// 최종값 담기
		String[] answer = new String[number];
		for (int i = 0; i < number; i++) {
			String add = "";
			for (int j = 0; j < number; j++) {
				add += twoArrString1[i][j];
			}
			answer[i] = add;
		}
		return answer;
	}

//	======================================================
	public static void main(String[] args) {

		HiddenMap HM = new HiddenMap();

		String[] answer1 = HM.solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 });
		System.out.println(Arrays.toString(answer1));

		String[] answer2 = HM.solution(6, new int[] { 46, 33, 33, 22, 31, 50 }, new int[] { 27, 56, 19, 14, 14, 10 });
		System.out.println(Arrays.toString(answer2));

	}

}
