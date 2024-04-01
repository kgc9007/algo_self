// BOJ 5525번 IOIOI
// https://www.acmicpc.net/problem/5525

package BOJ.no5525;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String S = sc.next();

		// IOI가 연속으로 반복되는 수 count
		int count = 0;
		// 전체 문자열에서 내가 구하려는 문자열이 포함된 횟수 result
		int result = 0;

		// 전체 문자열을 맨 앞에서부터 3글자씩 탐색
		for (int i = 1; i < M - 1; i++) {
			// 해당 글자가 O이고 앞, 뒤로 I이면 count(I + OI의 반복횟수)++
			if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				count++;

				// count(I + OI)의 반복횟수가 내가 찾으려는 문자열과 같아지면
				// result++, 다음 위치를 확인하기 위해 count--
				if (count == N) {
					count--;
					result++;
				}
				// 다음엔 두 글자 뒤를 확인하기 위해 i++
				i++;
			}
			// 아니면 count(I + OI의 반복횟수)초기화
			else {
				count = 0;
			}
		}

		// 결과 출력
		System.out.println(result);
	}
}
