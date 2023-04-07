package Solution5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution5 {

	public String solution(String[] votes, int k) {

		String answer = " ";
		HashMap<String, HashSet<String>> voteHash = new HashMap<>();
		HashMap<String, Integer> candidate = new HashMap<>();
		HashMap<String, Integer> present = new HashMap<>();

		// 배열을 받아와 x에 담고 반복돌린다.
		for (String x : votes) {
			// a = 투표한자 b = 투표받은자
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			// putIfAbsent() Key 값이 존재하는 경우 Map의 Value의 값을 반환하고,
			// Key값이 존재하지 않는 경우 Key와 Value를 Map에 저장하고 Null을 반환한다.
			voteHash.putIfAbsent(a, new HashSet<String>());
			// 해당 투표자를 키로 가져와 밸류값에 투표한자를 add담아준다.
			voteHash.get(a).add(b);
			// 투표받은자 이름 중복제거뒤 누적한다.
			candidate.put(b, candidate.getOrDefault(b, 0) + 1);
		}

		System.out.println("voteHash : " + voteHash);
		System.out.println("candidate : " + candidate);

		int max = Integer.MIN_VALUE;
		// voteHash에 있는 키값을 가지고 반복돈다.
		for (String a : voteHash.keySet()) {
			int cnt = 0;

			for (String b : voteHash.get(a)) {
				if (candidate.get(b) >= k)
					cnt++;
			}
			present.put(a, cnt);
			max = Math.max(max, cnt);
		}

		ArrayList<String> tmp = new ArrayList<>();

		for (String name : present.keySet()) {
			if (present.get(name) == max)
				tmp.add(name);
		}

		tmp.sort((a, b) -> a.compareTo(b));
		answer = tmp.get(0);
		return answer;

	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		System.out.println(T.solution(
				new String[] { "john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john" }, 2));
//		System.out.println(T.solution(new String[] { "john tom", "park luis", "john luis", "luis tom", "park tom",
//				"luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis" }, 2));
//		System.out.println(T.solution(new String[] { "cody tom", "john tom", "cody luis", "daniel luis", "john luis",
//				"luis tom", "daniel tom", "luis john" }, 2));
//		System.out.println(T.solution(new String[] { "bob tom", "bob park", "park bob", "luis park", "daniel luis",
//				"luis bob", "park luis", "tom bob", "tom luis", "john park", "park john" }, 3));
	}
}