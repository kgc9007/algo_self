// BOJ 14890번 경사로
// SWEA 활주로 건설과 동일

package BOJ.no14890;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 지도의 크기 N * N, 경사로 길이 X 입력
		int N = sc.nextInt();
		int L = sc.nextInt();

		// 각 칸의 높이 정보 입력
		int[][] map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 결과 출력
		System.out.println(solve(map, L));
	}

	public static int solve(int[][] map, int L) {
		int count = 0;

		int N = map.length;
		boolean[][] used;

		// 첫번째 행부터 행별로 지나갈 수 있는지 확인
		for (int r = 0; r < N; r++) {
			// 해당 지역에 경사로를 썼는지 확인
			used = new boolean[N][N];
			// 지나갈 수 있는지를 저장할 변수
			boolean canPass = true;
			// 첫번째 지형의 높이를 기준으로 설정
			int height = map[r][0];
			for (int c = 1; c < N; c++) {
				if (map[r][c] > height + 1 || map[r][c] < height - 1) {
					canPass = false;
					break;
				}
				// 이후 지형의 높이가 1 작은 경우
				if (map[r][c] == height - 1) {
					// 경사로를 설치할 수 있는지 확인
					boolean flag = true;
					for (int i = 0; i < L; i++) {
						if (c + i >= N || map[r][c] != map[r][c + i]) {
							flag = false;
							break;
						}
					}
					// 경사로를 설치할 수 있는 경우
					// 경사로 길이(X)만큼 이동, 기준 높이 1 감소
					if (flag) {
						// 해당 지역에 경사로를 사용했음을 표시
						for (int i = 0; i < L; i++) {
							used[r][c + i] = true;
						}
						c += L - 1;
						height -= 1;
					}
					// 경사로를 설치할 수 없는 경우
					else {
						canPass = false;
						break;
					}
				}
				// 이후 지형의 높이가 1 큰 경우
				if (map[r][c] == height + 1) {
					// 경사로를 설치할 수 있는지 확인
					boolean flag = true;
					for (int i = -1; i >= -L; i--) {
						if (c + i < 0 || map[r][c - 1] != map[r][c + i] || used[r][c + i]) {
							flag = false;
							break;
						}
					}
					// 경사로를 설치할 수 있는 경우
					// 경사로 길이(X)만큼 이동, 기준 높이 1 증가
					if (flag) {
						height += 1;
					}
					// 경사로를 설치할 수 없는 경우
					else {
						canPass = false;
						break;
					}
				}
			}

			// 마지막까지 확인 후 통과할 수 있으면 count++
			if (canPass) {
				count++;
			}
		}

		// 첫번째 행부터 행별로 지나갈 수 있는지 확인
		for (int c = 0; c < N; c++) {
			// 해당 지역에 경사로를 썼는지 확인
			used = new boolean[N][N];
			// 지나갈 수 있는지를 저장할 변수
			boolean canPass = true;
			// 첫번째 지형의 높이를 기준으로 설정
			int height = map[0][c];
			for (int r = 1; r < N; r++) {
				if (map[r][c] > height + 1 || map[r][c] < height - 1) {
					canPass = false;
					break;
				}
				// 이후 지형의 높이가 1 작은 경우
				if (map[r][c] == height - 1) {
					// 경사로를 설치할 수 있는지 확인
					boolean flag = true;
					for (int i = 0; i < L; i++) {
						if (r + i >= N || map[r][c] != map[r + i][c]) {
							flag = false;
							break;
						}
					}
					// 경사로를 설치할 수 있는 경우
					// 경사로 길이(X)만큼 이동, 기준 높이 1 감소
					if (flag) {
						// 해당 지역에 경사로를 사용했음을 표시
						for (int i = 0; i < L; i++) {
							used[r + i][c] = true;
						}
						r += L - 1;
						height -= 1;
					}
					// 경사로를 설치할 수 없는 경우
					else {
						canPass = false;
						break;
					}
				}
				// 이후 지형의 높이가 1 큰 경우
				if (map[r][c] == height + 1) {
					// 경사로를 설치할 수 있는지 확인
					boolean flag = true;
					for (int i = -1; i >= -L; i--) {
						if (r + i < 0 || map[r - 1][c] != map[r + i][c] || used[r + i][c]) {
							flag = false;
							break;
						}
					}
					// 경사로를 설치할 수 있는 경우
					// 경사로 길이(X)만큼 이동, 기준 높이 1 증가
					if (flag) {
						height += 1;
					}
					// 경사로를 설치할 수 없는 경우
					else {
						canPass = false;
						break;
					}
				}
			}

			// 마지막까지 확인 후 통과할 수 있으면 count++
			if (canPass) {
				count++;
			}
		}

		// 통과할 수 있는 길의 수 반환
		return count;
	}
}