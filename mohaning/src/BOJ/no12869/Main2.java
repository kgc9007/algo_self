// BOJ 12869번 뮤탈리스크
// https://www.acmicpc.net/problem/12869

package BOJ.no12869;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	// SCV의 체력을 저장할 배열
	static int[] SCV = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			SCV[i] = sc.nextInt();
		}

		int count = 0;
		while (!allDestroyed()) {
			count++;
			Arrays.sort(SCV);
			SCV[2] -= 9;
			SCV[1] -= 3;
			SCV[0] -= 1;
		}

		// 결과 출력
		System.out.println(count);
	}

	// 모든 SCV의 체력이 0 또는 그 이하인지(파괴되었는지) 확인하는 메소드
	public static boolean allDestroyed() {
		return SCV[0] <= 0 && SCV[1] <= 0 && SCV[2] <= 0;
	}
}
