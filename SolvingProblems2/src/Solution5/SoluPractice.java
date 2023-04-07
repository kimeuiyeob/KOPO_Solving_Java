package Solution5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoluPractice {

	public String solution(String[] votes, int k) {

		String answer = " ";
		// 투표한자들을 담을 배열 생성한다.
		String[] getter = new String[votes.length];
		String[] split = new String[2];
		// 반복을 통해 split으로 나눠 투표받은자만 배열에 담는다.
		for (int i = 0; i < votes.length; i++) {
			split = votes[i].split(" ");
			getter[i] = split[1];
		}
		System.out.println("투표 받은자 : " + Arrays.toString(getter));

		// HashMap사용해서 이름의 중복을 제거하고 같은 키가 오면 값을 +1씩 누적한다.
		Map<String, Integer> HM = new HashMap<>();
		for (String string : getter) {
			HM.put(string, HM.getOrDefault(string, 0) + 1);
		}
		System.out.println("중복 제거 갯수 세기 : " + HM);

		// Map이 값꺼내오기 불편해서 리스트에 담으려고 생성한다.
		List<String> moreThan2 = new ArrayList<>();
		// HashMap은 밸류값을 가져오기 위해서 Map.Entry객체 사용한다. entrySet()키와 밸류를 관리한다.
		for (Map.Entry<String, Integer> string : HM.entrySet()) {
			// 밸류값이 매게변수 값보다 같거나 크다면 회장선거 나갈수있어서
			// 조건문에 맞는 사람들을 리스트에 담아준다.
			if (string.getValue() >= k) {
				moreThan2.add(string.getKey());
			}
		}
		System.out.println("매게변수 갯수보다 투표 많이 받은자 : " + moreThan2);

		// HashMap사용해서 선물 받은자를 중복제거하고 카운트한다.
		Map<String, Integer> HashM = new HashMap<>();
		for (int i = 0; i < votes.length; i++) {
			split = votes[i].split(" ");
			for (int j = 0; j < moreThan2.size(); j++) {
				if (split[1].equals(moreThan2.get(j))) {
					HashM.put(split[0], HashM.getOrDefault(split[0], 0) + 1);
				}
			}
		}
		System.out.println("선물 받은 자 : " + HashM);

		// 최고값을 구하기 위해 변수 생성한다.
		int max = Integer.MIN_VALUE;
		// 가장 선물을 많이 받은 값을 변수에 담아준다.
		for (Map.Entry<String, Integer> string : HashM.entrySet()) {
			if (string.getValue() > max) {
				max = string.getValue();
			}
		}
		System.out.println("선물 제일 많이 받은 값 : " + max);

		// 가장 선물을 많이받은 값이랑 동일한 밸류값을 가지고있는 사람들을 리스트에 담는다.
		List<String> finalPerson = new ArrayList<>();
		for (Map.Entry<String, Integer> string : HashM.entrySet()) {
			if (string.getValue() == max) {
				finalPerson.add(string.getKey());
			}
		}
		// 그 값들중 알파벳순으로 정렬해야하기 때문에 Collections.sort사용한다.
		Collections.sort(finalPerson);
		// 첫번째에 있는 사람을 가져온다.
		answer = finalPerson.get(0);
		return answer;
	}

	public static void main(String[] args) {
		SoluPractice T = new SoluPractice();
		System.out.println(T.solution(
				new String[] { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "john tom", "park luis", "john luis", "luis tom", "park tom",
				"luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis" }, 2));
		System.out.println(T.solution(new String[] { "cody tom", "john tom", "cody luis", "daniel luis", "john luis",
				"luis tom", "daniel tom", "luis john" }, 2));
		System.out.println(T.solution(new String[] { "bob tom", "bob park", "park bob", "luis park", "daniel luis",
				"luis bob", "park luis", "tom bob", "tom luis", "john park", "park john" }, 3));
	}
}