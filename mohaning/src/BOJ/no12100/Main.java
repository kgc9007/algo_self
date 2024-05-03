// BOJ 12100번 2048 (Easy)
// https://www.acmicpc.net/problem/12100

package BOJ.no12100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	// 게임판의 크기 N
	// 게임판의 상태(각 칸의 숫자)를 저장할 배열 board
	static int N;
	static int[][] board;

	// 순열 결과를 저장할 배열 result
	static int[] result = new int[5];;

	// 얻을 수 있는 최대 점수(가장 큰 블록의 숫자)
	static int maxScore = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// [input]
		N = sc.nextInt();
		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = sc.nextInt();
			}
		}

		// 순열실시 + 최대값 계산
		getPermutation(0);

		// 결과 출력
		System.out.println(maxScore);

	}

	// 중복순열을 이용하여 얻을 수 있는 가장 큰 블록 계산
	public static void getPermutation(int idx) {
		// 5번의 이동 방향을 모두 정했다면 결과 확인
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

	// 5번의 이동 후 최종 게임판의 상태를 구하는 메소드
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
	// 각 방향별로 구분 (direction : 1 ~ 4)
	// 방향에 맞는 순서대로 한줄씩 확인
	// 1. 0이라면 패스
	// 2. 0이 아닌 숫자라면 덱의 마지막에 있는 숫자와 비교
	// -> 같다면 덱의 마지막 숫자를 제거하고 * 2 하여 덱에 추가
	// 3. 이미 한번 합쳐진 숫자라면 더 이상 합쳐질 수 X
	// -> canCombine 변수를 사용하여 더 합쳐질 수 있는 수인지 구분
	public static int[][] move(int[][] copy, int direction) {
		int[][] tmp = new int[N][N];

		// 위로 이동
		if (direction == 1) {
			for (int c = 0; c < N; c++) {
				Deque<Integer> deque = new LinkedList<>();
				boolean canCombine = true;
				for (int r = 0; r < N; r++) {
					if (copy[r][c] != 0) {
						if (!deque.isEmpty() && deque.peekLast() == copy[r][c] && canCombine) {
							deque.offerLast(deque.pollLast() * 2);
							canCombine = false;
						} else {
							deque.offerLast(copy[r][c]);
							canCombine = true;
						}
					}
				}
				int length = deque.size();
				for (int r = 0; r < length; r++) {
					tmp[r][c] = deque.pollFirst();
				}
			}
		}
		// 아래로 이동
		if (direction == 2) {
			for (int c = 0; c < N; c++) {
				Deque<Integer> deque = new LinkedList<>();
				boolean canCombine = true;
				for (int r = N - 1; r >= 0; r--) {
					if (copy[r][c] != 0) {
						if (!deque.isEmpty() && deque.peekLast() == copy[r][c] && canCombine) {
							deque.offerLast(deque.pollLast() * 2);
							canCombine = false;
						} else {
							deque.offerLast(copy[r][c]);
							canCombine = true;
						}
					}
				}
				int length = deque.size();
				for (int r = N - 1, i = 0; i < length; r--, i++) {
					tmp[r][c] = deque.pollFirst();
				}
			}
		}
		// 오른쪽으로 이동
		if (direction == 3) {
			for (int r = 0; r < N; r++) {
				Deque<Integer> deque = new LinkedList<>();
				boolean canCombine = true;
				for (int c = 0; c < N; c++) {
					if (copy[r][c] != 0) {
						if (!deque.isEmpty() && deque.peekLast() == copy[r][c] && canCombine) {
							deque.offerLast(deque.pollLast() * 2);
							canCombine = false;
						} else {
							deque.offerLast(copy[r][c]);
							canCombine = true;
						}
					}
				}
				int length = deque.size();
				for (int c = 0; c < length; c++) {
					tmp[r][c] = deque.pollFirst();
				}
			}
		}
		// 왼쪽으로 이동
		if (direction == 4) {
			for (int r = 0; r < N; r++) {
				Deque<Integer> deque = new LinkedList<>();
				boolean canCombine = true;
				for (int c = N - 1; c >= 0; c--) {
					if (copy[r][c] != 0) {
						if (!deque.isEmpty() && deque.peekLast() == copy[r][c] && canCombine) {
							deque.offerLast(deque.pollLast() * 2);
							canCombine = false;
						} else {
							deque.offerLast(copy[r][c]);
							canCombine = true;
						}
					}
				}
				int length = deque.size();
				for (int c = N - 1, i = 0; i < length; c--, i++) {
					tmp[r][c] = deque.pollFirst();
				}
			}
		}

		return tmp;
	}

	// 최종 게임판의 상태를 기준으로 가장 큰 블록의 값과 현재 최대값을 비교, 갱신
	public static void getMaxBlock(int[][] copy) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				maxScore = Math.max(maxScore, copy[r][c]);
			}
		}
	}

}
