// BOJ 5525번 IOIOI
// https://www.acmicpc.net/problem/5525

package BOJ.no5525;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static String S;

	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.next();

		for (int i = 0; i < M - 2 * N; i++) {
			if (S.charAt(i) == 'I') {
				if(check(i, N * 2 + 1)) {
					i++;
				}
			}
		}
		
		// 결과 출력
		System.out.println(count);
	}

	public static boolean check(int start, int checkLength) {
		for (int i = start; i < start + checkLength; i += 2) {
			if (S.charAt(i) != 'I') {
				return false;
			}
		}
		for (int i = start + 1; i < start + checkLength; i += 2) {
			if (S.charAt(i) != 'O') {
				return false;
			}
		}

		count++;
		return true;
	}
}
