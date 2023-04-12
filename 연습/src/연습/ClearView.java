package ¿¬½À;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClearView {

	public int[] solution(String[] wallpaper) {

		int length = wallpaper.length;
		int smallLength = 0;
		for (int i = 0; i < wallpaper.length; i++) {
			smallLength = wallpaper[i].length();
		}

//		==============================================

		String[][] intArr = new String[length][smallLength];

		for (int i = 0; i < wallpaper.length; i++) {
			String paper = wallpaper[i];
			for (int j = 0; j < paper.length(); j++) {
				intArr[i][j] = String.valueOf(paper.charAt(j));
			}
		}

//		==============================================

		List<Integer> Number1 = new ArrayList<>();
		List<Integer> Number2 = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < smallLength; j++) {
				if (intArr[i][j].equals("#")) {
					Number1.add(i);
					Number2.add(j);
				}
			}
		}

		int minNum1 = Integer.MAX_VALUE;
		int minNum2 = Integer.MAX_VALUE;
		int maxNum1 = Integer.MIN_VALUE;
		int maxNum2 = Integer.MIN_VALUE;

		for (int i = 0; i < Number1.size(); i++) {
			if (minNum1 > Number1.get(i)) {
				minNum1 = Number1.get(i);
			}
			if (minNum2 > Number2.get(i)) {
				minNum2 = Number2.get(i);
			}
			if (maxNum1 < Number1.get(i)) {
				maxNum1 = Number1.get(i);
			}
			if (maxNum2 < Number2.get(i)) {
				maxNum2 = Number2.get(i);
			}
		}

		int[] answer = { minNum1, minNum2, maxNum1 + 1, maxNum2 + 1 };
		return answer;
	}

	public static void main(String[] args) {

		ClearView clear = new ClearView();

		System.out.println(Arrays.toString(clear.solution(new String[] { ".#...", "..#..", "...#." })));
		System.out.println(Arrays.toString(
				clear.solution(new String[] { "..........", ".....#....", "......##..", "...##.....", "....#....." })));
		System.out.println(Arrays.toString(clear.solution(new String[] { ".##...##.", "#..#.#..#", "#...#...#",
				".#.....#.", "..#...#..", "...#.#...", "....#...." })));
		System.out.println(Arrays.toString(clear.solution(new String[] { "..", "#." })));

	}

}
