package Solution1;

import java.util.Stack;

public class Solution1 {

	public String solution(String s) {
		// 답을 담아줄 변수생성
		String answer = "";
		// 압축해제 같은 문제는 Stack LIFO 방식 사용
		Stack<String> st = new Stack<>();
		// 문자열을 가져와 문자로 찢어 반복돌린다
		for (Character x : s.toCharArray()) {
			// 넘어온 문자가 )일때
			if (x == ')') {
				// 값을 담아줄 벼수 생성
				String temp = "";
				// Stack의 값이 비어있을때까지 반복돈다.
				while (!st.empty()) {
					// 값을 빼네 c변수에 담아준다.
					// 이 if문에 x == ) 일때 들어온거니까
					String c = st.pop();
					System.out.println("stack에 담긴 마지막 값 : " + c);
					// 만약 빼낸 값이 ( 면
					if (c.equals("(")) {
						// 값을 담아줄 변숫 생성
						String num = "";
						// Character.isDigit() 숫자인지 판단하는 Character내장 함수
						System.out.println("값 확인 : " + st.peek());
						// 만약 st안에 값이 있고 마지막에 담긴 값이 숫자라면 그 숫자를 빼네 num에 담아준다.
						while (!st.empty() && Character.isDigit(st.peek().charAt(0))) {
							num = st.pop() + num;
						}
						String res = "";
						int cnt = 0;
						// 만약 num이 비어있다면 1을
						if (num.equals("")) {
							cnt = 1;
						} else {
							// 아니면 형변환 해서 그 숫자를 담아준다.
							// 예를들어 string문자열이 2가 나왔다면 숫자 2로 바까서 cnt에 담아주는거다.
							// 이숫자만큼 그문자열을 반복돌려서 담아줘야하기 때문이다.
							cnt = Integer.parseInt(num);
						}
						// 여기서 해당 숫자만큼 반복돌려 res에 담아주고 res를 다시 st에 담아준다.
						for (int i = 0; i < cnt; i++) {
							res += temp;
						}
						st.push(res);
						break;
					}
					// 마지막 빼낸 값이 ( 아니라면 temp에 값을 추가한다.
					// 이때 c의 위치가 중요하다.
					temp = c + temp;
				}
			} else {
				// )를 만나지 않은 문자들은 st stack에 담아준다.
				st.push(String.valueOf(x));
			}
		}
		for (String x : st) {
			answer += x;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution1 T = new Solution1();
//		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
//		System.out.println(T.solution("2(ab3((cd)))"));
//		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
//		System.out.println(T.solution("3(ab2(sg))"));
	}
}