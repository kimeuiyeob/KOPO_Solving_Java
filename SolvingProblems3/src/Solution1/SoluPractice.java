package Solution1;

import java.util.Stack;

public class SoluPractice {
	public String solution(String s) {
		String answer = "";
		Stack<String> stack = new Stack<>();

		for (char oneLetter : s.toCharArray()) {

			if (oneLetter == ')') {
				String temp = "";
				while (!stack.isEmpty()) {
					String str = stack.pop();
					if (str.equals("(")) {
						String num = "";
						while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) {
							num = stack.pop() + num;
						}
						String res = "";
						int cnt = 0;
						if (num.equals("")) {
							cnt = 1;
						} else {
							cnt = Integer.parseInt(num);
						}
						for (int i = 0; i < cnt; i++) {
							res += temp;
						}
						stack.push(res);
						break;
					}
					temp = str + temp;
				}
			} else {
				stack.push(String.valueOf(oneLetter));
			}
		}
		for (String x : stack) {
			answer += x;
		}
		return answer;
	}

	public static void main(String[] args) {
		SoluPractice T = new SoluPractice();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}