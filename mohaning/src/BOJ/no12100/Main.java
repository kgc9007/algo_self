// BOJ 12100번 2048 (Easy)
// https://www.acmicpc.net/problem/12100

package BOJ.no12100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] board;

	static int[] result = new int[5];;

	static int maxScore = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
		getPermutation(0);
		
		// 결과 출력
		System.out.println(maxScore);

	}

	// 중복순열을 이용하여 얻을 수 있는 가장 큰 블록 계산
	public static void getPermutation(int idx) {
		if (idx == 5) {
			int[][] copy = getMoveResult(result);
			getMaxBlock(copy);
			return;
		}

		result[idx] = 1;
		getPermutation(idx + 1);

		result[idx] = 2;
		getPermutation(idx + 1);

		result[idx] = 3;
		getPermutation(idx + 1);

		result[idx] = 4;
		getPermutation(idx + 1);
	}

	//
	public static int[][] getMoveResult(int[] direction) {
		int[][] copy = new int[N][N];
		for (int r = 0; r < N; r++) {
			copy[r] = Arrays.copyOf(board[r], N);
		}

		for (int i = 0; i < 5; i++) {
			copy = move(copy, direction[i]);
		}

		return copy;
	}

	// 보드 이동 결과를 구하는 메소드
	public static int[][] move(int[][] copy, int direction) {
		int[][] tmp = new int[N][N];

		// 위로 이동
		if (direction == 1) {
			for (int c = 0; c < N; c++) {
				List<Integer> list = new ArrayList<>();
				for (int r = 0; r < N; r++) {
					if (copy[r][c] == 0) {
						break;
					}
					if (copy[r][c] != 0) {
						if (r < N - 1 && copy[r][c] == copy[r + 1][c]) {
							list.add(copy[r][c] * 2);
							r++;
						} else {
							list.add(copy[r][c]);
						}
					}
				}
				for (int r = 0; r < list.size(); r++) {
					tmp[r][c] = list.get(r);
				}
			}
		}
		// 아래로 이동
		if (direction == 2) {
			for (int c = 0; c < N; c++) {
				List<Integer> list = new ArrayList<>();
				for (int r = N - 1; r >= 0; r--) {
					if (copy[r][c] == 0) {
						break;
					}
					if (copy[r][c] != 0) {
						if (r > 0 && copy[r][c] == copy[r - 1][c]) {
							list.add(copy[r][c] * 2);
							r--;
						} else {
							list.add(copy[r][c]);
						}
					}
				}
				for (int r = N - 1, i = 0; i < list.size(); r--, i++) {
					tmp[r][c] = list.get(i);
				}
			}
		}
		// 오른쪽으로 이동
		if (direction == 3) {
			for (int r = 0; r < N; r++) {
				List<Integer> list = new ArrayList<>();
				for (int c = 0; c < N; c++) {
					if (copy[r][c] == 0) {
						break;
					}
					if (copy[r][c] != 0) {
						if (c < N - 1 && copy[r][c] == copy[r][c + 1]) {
							list.add(copy[r][c] * 2);
							c++;
						} else {
							list.add(copy[r][c]);
						}
					}
				}
				for (int c = 0; c < list.size(); c++) {
					tmp[r][c] = list.get(c);
				}
			}
		}
		// 왼쪽으로 이동
		if (direction == 4) {
			for (int r = 0; r < N; r++) {
				List<Integer> list = new ArrayList<>();
				for (int c = N - 1; c >= 0; c--) {
					if (copy[r][c] == 0) {
						break;
					}
					if (copy[r][c] != 0) {
						if (c > 0 && copy[r][c] == copy[r][c - 1]) {
							list.add(copy[r][c] * 2);
							c--;
						} else {
							list.add(copy[r][c]);
						}
					}
				}
				for (int c = N - 1, i = 0; i < list.size(); c--, i++) {
					tmp[r][c] = list.get(i);
				}
			}
		}

		return tmp;
	}

	//
	public static void getMaxBlock(int[][] copy) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				maxScore = Math.max(maxScore, copy[r][c]);
			}
		}
	}

}
