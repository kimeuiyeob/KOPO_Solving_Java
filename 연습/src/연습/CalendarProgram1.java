package 연습;

import java.util.Scanner;

class CalendarProgram1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int year; // 사용자 입력 <== 년도 받아오기
		int month; // 사용자 입력 <== 월 받아오기

		int dayOfWeek; // 저장용 변수
		int sum = 0; // 현재의 모든 일 계산 변수

		int basicYear[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 달별로 끝나는 날짜 저장

		System.out.printf("년도 입력 해주세요 : ");
		year = sc.nextInt();
		System.out.printf("월 입력 해주세요 : ");
		month = sc.nextInt();

		// 윤달 확인
		// 년도를 보내서 숫자1을 받으면 윤달 -> 2월달에 하루를 더해준다.
		int yoondal = checkYoonDal(year);
		if (yoondal == 1) {
			basicYear[1] += 1;
		}

		// 1900년도부터 시작
		for (int i = 1900; i < year; i++) {
			int yoon = checkYoonDal(i);
			if (yoon == 1) {
				sum += 366; // 윤달일시 하루더 김
			} else {
				sum += 365;
			}
		}

		// 입력한 달까지 몇일인지 계산후 sum에 누적
		for (int i = 0; i < month - 1; i++) {
			sum += basicYear[i];
		}

		// 현재 sum은 1900년부터 입력받는 년도까지 모든 날짜 더한다, 윤년 포함, 현재 달의 날짜까지
		sum += 1;

		// 모든 날짜를 일주일 7로 나눴을때 나머지가 현재 요일이다.
		dayOfWeek = sum % 7;

		System.out.printf("==================== %d년 %d월====================\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

		// 시작 요일에 맞춰 정렬
		for (int j = 0; j < dayOfWeek; j++) {
			System.out.printf("\t");
		}

		// 현재 달의 날짜만큼 반복
		for (int i = 1; i <= basicYear[month - 1]; i++) {
			System.out.printf("%d\t", i);

			if (dayOfWeek == 6) {
				dayOfWeek = -1;
				System.out.printf("\n");
			}
			dayOfWeek++;
		}

	}

	// 윤달 확인 함수
	static int checkYoonDal(int a) {
		if ((a % 4 == 0) && !(a % 100 == 0) || (a % 400 == 0)) {
			return 1;
		} else {
			return 0;
		}
	}

}