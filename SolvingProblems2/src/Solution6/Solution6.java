package Solution6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution6 {

	public String[] solution(String[] reports, String times) {

		String[] name = new String[reports.length]; // 이름들
		String[] time = new String[reports.length]; // 시간들
		String[] hourSplitMin = new String[2]; // 시간과 분 쪼개기
		int hourPlusMin = 0;
		int[] hourplusMinutes = new int[time.length];

		String[] split = new String[2];

		for (int i = 0; i < time.length; i++) {
			split = reports[i].split(" ");
			name[i] = split[0];
			time[i] = split[1];
		}
		for (int i = 0; i < time.length; i++) {
			hourSplitMin = time[i].split(":");
			hourPlusMin = (Integer.parseInt(hourSplitMin[0]) * 60) + (Integer.parseInt(hourSplitMin[1]));
			hourplusMinutes[i] = hourPlusMin;
		}

		HashMap<String, Integer> HM = new HashMap<>();
		for (int i = 0; i < name.length; i++) {
			HM.put(name[i], hourplusMinutes[i]);
		}
//	      ==============================================================
		String[] answerTime = new String[2];
		String[] splitanswerTime = new String[2];
		int[] answerHourplusMinutes = new int[answerTime.length]; // [0] ~[1] 사이에 값이 있는사람
		int answerTimeplit = 0;

		for (int i = 0; i < times.length(); i++) {
			answerTime = times.split(" ");
		}
		for (int i = 0; i < answerTime.length; i++) {
			splitanswerTime = answerTime[i].split(":");
			answerTimeplit = (Integer.parseInt(splitanswerTime[0]) * 60) + (Integer.parseInt(splitanswerTime[1]));
			answerHourplusMinutes[i] = answerTimeplit;
		}

		List<String> nameList = new ArrayList<>();

		for (Map.Entry<String, Integer> pair : HM.entrySet()) {
			if (pair.getValue() >= answerHourplusMinutes[0] && pair.getValue() <= answerHourplusMinutes[1]) {
				nameList.add(pair.getKey());
			}
		}
		String[] answer = new String[nameList.size()];

		for (int i = 0; i < nameList.size(); i++) {
			answer[i] = nameList.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution6 T = new Solution6();
		System.out.println(Arrays.toString(
				T.solution(new String[] { "john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57" },
						"08:33 09:45")));
		System.out
				.println(
						Arrays.toString(
								T.solution(
										new String[] { "ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57",
												"bill 17:35", "tom 07:23", "john 15:23", "park 09:59" },
										"15:01 19:59")));
		System.out.println(Arrays.toString(
				T.solution(new String[] { "cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50" },
						"14:20 15:20")));
	}
}