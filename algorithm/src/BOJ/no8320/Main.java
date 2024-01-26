// BOJ 8320번 직사각형을 만드는 방법

package BOJ.no8320;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정사각형의 개수 N 입력
		int N = sc.nextInt();

		int cnt = 0;

		// i : 가로의 길이
		// j : 세로의 길이
		// 가로, 세로의 길이가 서로 반대인 경우를 제외하기 위해 j=i부터 확인
		// 단, N=1이면 cnt=1
		if (N == 1) {
			cnt = 1;
		} else {
			for (int i = 1; i <= N - 1; i++) {
				for (int j = i; i * j <= N; j++) {
					cnt++;
				}
			}
		}

		// 결과 출력
		System.out.println(cnt);

	}
}
