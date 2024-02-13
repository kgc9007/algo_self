// BOJ 1780번 종이의 개수

package BOJ.no1780;

import java.util.Scanner;

public class Main {
	
	// N * N 크기의 종이의 정보를 저장할 배열 map
	public static int[][] map;
	public static int[] count = new int[3];		// -1, 0, 1로만 채워진 종이의 개수를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 종이의 크기 N 입력
		int N = sc.nextInt();

		// map 배열 생성 및 정보 입력
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		cutPaper(0, 0, N);		
		
		// 결과 출력
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);

	}

	// 시작점의 좌표, 길이를 입력해서 모두 같은 값인지를 확인해서 반환하는 함수 isSame
	public static boolean isSame(int sr, int sc, int length) {
		for (int r = sr; r < sr + length; r++) {
			for (int c = sc; c < sc + length; c++) {
				if (map[r][c] != map[sr][sc]) {
					return false;					
				}
			}
		}
		return true;
	}

	// 종이의 모든 숫자가 같으면 해당 숫자에 해당하는 count++
	// 같지 않으면 종이를 9개로 나누어서 다시 실행
	// 나누는 과정에서 길이는 N -> 3/N으로 변경
	// 길이(N)이 1이되면 항상 isSame = true이므로 자동으로 종료
	public static void cutPaper(int sr, int sc, int N) {
		if (isSame(sr, sc, N)) {
			count[map[sr][sc] + 1]++;
			return;
		}
		
		cutPaper(sr, sc, N / 3);
		cutPaper(sr, sc + N / 3, N / 3);
		cutPaper(sr, sc + N * 2 / 3, N / 3);
		cutPaper(sr + N / 3, sc, N / 3);
		cutPaper(sr + N / 3, sc + N / 3, N / 3);
		cutPaper(sr + N / 3, sc + N * 2 / 3, N / 3);
		cutPaper(sr + N * 2 / 3, sc, N / 3);
		cutPaper(sr + N * 2 / 3, sc + N / 3, N / 3);
		cutPaper(sr + N * 2 / 3, sc + N * 2 / 3, N / 3);

	}
}
