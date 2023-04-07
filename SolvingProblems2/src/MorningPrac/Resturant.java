package MorningPrac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resturant {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Integer> menuList = new ArrayList<>();
		List<Integer> menuPrice = new ArrayList<>();

		double revenue = 0.66;
		double partTime = 12000 / 60.0; // 분당 200원
		int cookingTime = 20;

		System.out.println("메뉴를 골라주세요~~");

		while (true) {
			System.out.println("1. 제육볶음 : 9000원");
			System.out.println("2. 오징어볶음 : 12000원");
			System.out.println("3. 김치찌개 : 8000원");
			System.out.println("4. 된장찌개 : 8000원");
			System.out.println("5. 사이다 : 2000원");
			System.out.println("6. 그만 고를께요");

			int chooseMenu = sc.nextInt();

			if (chooseMenu == 1) {
				System.out.println("고르신 메뉴는 제육볶음입니다.");
				System.out.println("더 고르시겠습니까?");
				menuPrice.add(9000);
			} else if (chooseMenu == 2) {
				System.out.println("고르신 메뉴는 오징어볶음입니다.");
				System.out.println("더 고르시겠습니까?");
				menuPrice.add(12000);
			} else if (chooseMenu == 3) {
				System.out.println("고르신 메뉴는 김치찌개입니다.");
				System.out.println("더 고르시겠습니까?");
				menuPrice.add(8000);
			} else if (chooseMenu == 4) {
				System.out.println("고르신 메뉴는 된장찌개입니다.");
				System.out.println("더 고르시겠습니까?");
				menuPrice.add(8000);
			} else if (chooseMenu == 5) {
				System.out.println("고르신 메뉴는 사이다입니다.");
				System.out.println("더 고르시겠습니까?");
				menuPrice.add(2000);
			} else if (chooseMenu == 6) {
				System.out.println("감사합니다~");
				break;
			} else {
				System.out.println("1~6번중 골라주세요~");
			}
			menuList.add(chooseMenu);
		}
		int totalIncomeMoney = 0;
		for (int i = 0; i < menuPrice.size(); i++) {
			totalIncomeMoney += menuPrice.get(i);
		}
		System.out.println("총 금액은 : " + totalIncomeMoney + " 원입니다.");

		double revenueTotal = 0;
		int totalCookingTime = 0;

		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i) > 0 && menuList.get(i) < 5) {
				totalCookingTime += cookingTime;
			}
		}
		int giveMoneyManagerMoney = (int) totalCookingTime * (int) partTime;

		revenueTotal = totalIncomeMoney * revenue - giveMoneyManagerMoney;
		System.out.println("사장님의 총 수익 : " + (int) revenueTotal + "원 입니다.");

	}

}
