package ¿¬½À;

import java.util.Scanner;

public class Snail {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[][] arr = new int[number][number];
		int flag = 1;

		int k = 1;
		int a = 0;
		int b = -1;

		while (true) {
			for (int i = 0; i < number; i++) {
				b += flag;
				arr[a][b] = k;
				k += 1;
			}
			number -= 1;
			for (int i = 0; i < number; i++) {
				a += flag;
				arr[a][b] = k;
				k += 1;
			}
			flag *= -1;
			if (number == 0) {
				break;
			}
		}

//		===========================================

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}
}