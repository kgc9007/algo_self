// BOJ 1874번 스택 수열

package BOJ.no1874;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 길이 N 입력
		int N = sc.nextInt();

		// 가능한지 아닌지를 저장할 boolean 변수 possible을 true로 초기화
		boolean possible = true;
		// 가능하다면 결과를 출력하기 위해 result 리스트를 생성
		List<Character> result = new ArrayList<>();

		// 배열 stack 생성
		// 0이 이미 입력된 상태라고 가정 -> 배열의 크기 N + 1
		int[] stack = new int[N+1];
		// 현재 입력된 가장 큰 숫자 idx = 0으로 초기화
		int top = 0;
		int idx = 0;
		
		// N개의 숫자를 입력
		while (N-- > 0) {
			int num = sc.nextInt();

			// 입력된 숫자가 현채 스택의 마지막 원소보다 크면
			// num과 같아질 때까지 스택에 원소 추가
			// idx를 1씩 증가시킨 후 push
			// push 실시 후 결과에 '+' 추가
			if (num > stack[top]) {
				while (num != stack[top]) {
					stack[++top] = ++idx;
					result.add('+');
				}
				// 입력 이후 스택에서 마지막 숫자 pop
				// pop 실시 후 결과에 '-' 추가
				stack[top--] = 0;
				result.add('-');
			}
			// 스택의 마지막 원소가 num과 같다면 바로 pop
			// pop 실시 후 결과에 '-' 추가
			else if (num == stack[top]) {
				stack[top--] = 0;
				result.add('-');
			}
			// 출력해야 할 숫자(num)보다 스택에 더 큰 숫자가 이미 있는 경우
			// 주어진 수열 생성 불가 -> possible = false
			else {
				possible = false;
			}

		}

		// 결과 출력
		if (possible) {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		} else {
			System.out.println("NO");
		}
	}

}
