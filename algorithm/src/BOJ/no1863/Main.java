// BOJ 1863번 스카이라인 쉬운거
// https://www.acmicpc.net/problem/1863

package BOJ.no1863;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 스카이라인의 고도가 변하는 횟수 N
		int N = sc.nextInt();

		// 건물의 최소 개수 count = 0으로 초기화
		int count = 0;

		// 스택 생성 후 순회하며 개수 확인
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 스택이 비어있지 않으면
			if (!stack.isEmpty()) {
				// 해당 지점의 높이가 앞에 위치한 건물보다 낮다면 그만큼 count++, 스택에서 제거
				while (!stack.isEmpty() && stack.peek() > y) {
					count++;
					stack.pop();
				}
			}

			// 1. 이후 스택이 비어있거나, 스택의 마지막 원소와 같은 높이가 아니고
			// 2. 빈 땅이 아니라면 (높이가 0이 아니라면)
			// 스택에 추가
			if ((stack.isEmpty() || stack.peek() != y) && y != 0) {
				stack.push(y);
			}

//			System.out.println(stack.toString());
//			System.out.println("count : " + count);
		}

		// 스택에 남아있는 원소들만큼 건물의 개수에 추가
		count += stack.size();

		// 결과 출력
		System.out.println(count);
	}
}
